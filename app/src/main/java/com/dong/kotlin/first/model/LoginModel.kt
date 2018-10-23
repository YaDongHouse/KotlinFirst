package com.dong.kotlin.first.model

import com.dong.kotlin.first.presenter.LoginPresenter

/**
 * @packInfo:com.dong.kotlin.first.model
 * @author: yadong.qiu
 * Created by 邱亚东
 * Date: 2018/10/22
 * Time: 14:51
 */
interface LoginModel {

    /**
     * 登陆
     */
    fun login(onLoginListener: LoginPresenter.onLoginListener,username:String,password:String)

    /**
     * 注册
     */
    fun register(onRegisterListener: LoginPresenter.onRegisterListener,username: String,password: String,email:String)

}