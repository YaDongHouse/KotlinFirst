package com.dong.kotlin.first.bean

/**
 * @packInfo:com.dong.kotlin.first.bean
 * @author: yadong.qiu
 * Created by 邱亚东
 * Date: 2018/10/22
 * Time: 13:28
 */

/**
 * 登录返回result
 * token	用户登录生成的token
 * uid	用户Id
 */
 data class LoginResultResponse(
        val token:String,
        val uid:String
)