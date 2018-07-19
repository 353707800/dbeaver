package com.today.util

/**
 * Created with Intellij IDEA.
 * @author zhouhao
 * @version 2018/7/19 0019
 */
class StringRedisSerializer {

    /**
     * serialize
     * */
    fun serialize(string : String) : ByteArray{
        return string.toByteArray()
    }

    fun deserialize(bytes : ByteArray) : String{
        return String(bytes)
    }
}