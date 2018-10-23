package com.dong.kotlin.first.view

import com.dong.kotlin.first.bean.LoginResponse
import com.dong.kotlin.first.bean.RegisterResponse

/**
 * @packInfo:com.dong.kotlin.first.view
 * @author: yadong.qiu
 * Created by 邱亚东
 * Date: 2018/10/22
 * Time: 14:32
 */
interface LoginView {
    /**
     * 登陆成功
     */
    fun loginSuccess(result:LoginResponse)

    /**
     * 登陆失败
     */
    fun loginFailed(message:String)


    /**
     * 注册成功
     */
    fun registerSuccess(result:RegisterResponse)

    /**
     * 注册失败
     */
    fun registerFailed(message:String?)


}