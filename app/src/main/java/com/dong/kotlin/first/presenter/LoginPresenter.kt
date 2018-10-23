package com.dong.kotlin.first.presenter

import com.dong.kotlin.first.bean.LoginResponse
import com.dong.kotlin.first.bean.RegisterResponse

/**
 * @packInfo:com.dong.kotlin.first.presenter
 * @author: yadong.qiu
 * Created by 邱亚东
 * Date: 2018/10/22
 * Time: 14:43
 */
interface LoginPresenter {

    /**
     * 登陆
     */
    fun login(username:String,password:String)

    /**
     * 登陆接口
     */
    interface onLoginListener {
        /**
         * 登陆成功
         */
        fun loginSuccess(result:LoginResponse)

        /**
         * 登陆失败
         */
        fun loginFailed(message:String)
    }

    fun register(username:String,password:String,email:String)

    /**
     * 注册接口
     */
    interface onRegisterListener {

        /**
         * 注册成功
         */
        fun registerSuccess(result:RegisterResponse)

        /**
         * 注册失败
         */
        fun registerFailed(message:String?)
    }

}