package com.today.entity

import java.io.Serializable

/**
 * Created with Intellij IDEA.
 * @author zhouhao
 * @version 2018/7/13 0013
 */
data class BaseEntity(
        var id : String? = null,
        var createTime : Long? = null,
        var createBy : String? = null,
        var updateTime : Long? = null,
        var updateBy : String? = null,
        var remark : String? = null
) : Serializable