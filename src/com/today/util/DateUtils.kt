package com.today.util

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * Created with Intellij IDEA.
 * @author zhouhao
 * @version 2018/7/18 0018
 */
class DateUtils{
    fun timestampsConvertString(timestamp: Long?, pattern: String, zone: ZoneId): String {
        var timestamp = timestamp
        if (timestamp == null) {
            timestamp = System.currentTimeMillis()
        } else if (timestamp.toString().length == 10) {
            timestamp = timestamp * 1000
        }
        //Long 转 Date
        val date = Date(timestamp)
        //Date 转 Instant
        val instant = date.toInstant()
        //格式要求设置
        val dateTimeFormatter = DateTimeFormatter.ofPattern(pattern)
        //通过LocalDateTime 转换 时区设置系统默认时区
        val localDateTime = LocalDateTime.ofInstant(instant, zone)
        //返回结果
        return dateTimeFormatter.format(localDateTime)
    }

    fun timestampsConvertString(timestamp: Long?, pattern: String): String {
        val zone = ZoneId.systemDefault()
        return timestampsConvertString(timestamp, pattern, zone)
    }

    fun timestampsConvertString(timestamp: Long?): String {
        val pattern = "yyyy-MM-dd HH:mm:ss"
        return timestampsConvertString(timestamp, pattern)
    }
}