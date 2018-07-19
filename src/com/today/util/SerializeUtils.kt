package com.today.util

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

/**
 * Created with Intellij IDEA.
 * @author zhouhao
 * @version 2018/7/19 0019
 */
class SerializeUtils {

    /**
     * 序列化
     * */
    @Throws(Exception::class)
    fun serialize(obj : Any) : ByteArray{
        var baos = ByteArrayOutputStream()
        var oos = ObjectOutputStream(baos)
        oos.writeObject(obj)
        oos.flush()
        return baos.toByteArray()
    }

    /**
     * 反序列化
     * */
    fun unserialize(bytes : ByteArray) : Any{
        var bais = ByteArrayInputStream(bytes)
        var ois = ObjectInputStream(bais)
        return ois.readObject()
    }
}