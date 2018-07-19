package com.today.util

import com.today.entity.BaseEntity
import redis.clients.jedis.Jedis
import redis.clients.jedis.JedisPool



/**
 * Created with Intellij IDEA.
 * @author zhouhao
 * @version 2018/7/19 0019
 */
const val address = "localhost"

const val port = 6379

class RedisUtils{

    companion object {
        private var jedisPool : JedisPool
        init {
            jedisPool = JedisPool(address,port)
        }

        fun getRedis() : Jedis {
            var jedis = jedisPool.resource
            return jedis
        }

        @JvmStatic
        fun main(args: Array<String>) {
            //getRedis().set("key","hello world")
            //getRedis().hset("api","token","ksfkds#923j23jfj29ur292##(#JUJH0")
            //getRedis().lpush("fruit", "apple","banana","peach","plum")
            //getRedis().sadd("course","Kotlin","Java","Php","C#")
            /*var map = hashMapOf<String,Double>()
            map.put("cucumber",1.0)
            map.put("loofah",2.0)
            map.put("chives",3.0)
            map.put("mushroom",4.0)
            getRedis().zadd("vegetables",map)*/

            /*println(getRedis().get("key"))

            println(getRedis().hget("api","token"))

            println(getRedis().lrange("fruit",0,4))

            println(getRedis().smembers("course"))

            println(getRedis().zrange("vegetables",0,4))
*/
            //println(getRedis().set("memberId","this is my member","NX","EX",60))

            /*val key = getRedis().get("memberId")
            if(key == null){
                println(getRedis().set("memberId","this is my member","NX","PX",3500))
            }else{
                println("redis is lock")
            }*/
            var base = BaseEntity("123456",System.currentTimeMillis(),"json",remark = "test")
            //println(SerializeUtils().unserialize())
            getRedis().set("baseEntity".toByteArray(),SerializeUtils().serialize(base))
            var base1 = getRedis().get("baseEntity".toByteArray())
            println(SerializeUtils().unserialize(base1))
        }
    }

}