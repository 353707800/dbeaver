package com.today.util

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.databind.ObjectMapper
import com.today.entity.BaseEntity
import java.io.IOException

/**
 * Created with Intellij IDEA.
 * @author zhouhao
 * @version 2018/7/13 0013
 */
class ObjectMapperUtils {

    fun toJson(obj : Any) : String? {
        try {
            val mapper = ObjectMapper()
            return mapper.writeValueAsString(obj)
        }catch (e : JsonProcessingException){
            e.printStackTrace()
            return null
        }catch (e : Exception){
            e.printStackTrace()
            return null
        }
    }

    fun <T> fromJson(json : String,type : Class<T>) : T?{
        try{
            val mapper = ObjectMapper()
            return mapper.readValue(json,type)
        }catch (e : JsonParseException){
            e.printStackTrace()
            return null
        }catch (e : IOException){
            e.printStackTrace()
            return  null
        }
        catch (e : Exception){
            return null
        }
    }

    private fun fromCollectionType(collectionClass: Class<*>, vararg elementClasses: Class<*>): JavaType? {
        try {
            val mapper = ObjectMapper()
            return mapper.typeFactory.constructParametricType(collectionClass, *elementClasses)
        } catch (e: Exception) {
            return null
        }
    }

    fun <T> fromList(json: String, type: Class<T>): List<T>? {
        try {
            val javaType = fromCollectionType(List::class.java, type)
            val mapper = ObjectMapper()
            return mapper.readValue<Any>(json, javaType) as List<T>
        } catch (e: IOException) {
            return null
        } catch (e: Exception) {
            return null
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var base = BaseEntity("123456",System.currentTimeMillis(),"json",remark = "test")

            print(ObjectMapperUtils().toJson(base))

            var json = "[{\"id\": \"123456\",\"createTime\": 1531884364274,\"createBy\": \"json\",\"updateTime\": null,\"updateBy\": null,\"remark\": \"test\"},{\"id\": \"123456\",\"createTime\": 1531884364274,\"createBy\": \"json\",\"updateTime\": null,\"updateBy\": null,\"remark\": \"test\"},{\"id\": \"123456\",\"createTime\": 1531884364274,\"createBy\": \"json\",\"updateTime\": null,\"updateBy\": null,\"remark\": \"test\"}]"

            print(ObjectMapperUtils().fromList(json,(BaseEntity::class.java)))
        }
    }
}