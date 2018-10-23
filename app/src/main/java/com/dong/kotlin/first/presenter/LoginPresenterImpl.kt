package com.dong.kotlin.first.presenter

import com.dong.kotlin.first.bean.LoginResponse
import com.dong.kotlin.first.bean.RegisterResponse
import com.dong.kotlin.first.model.LoginModel
import com.dong.kotlin.first.model.LoginModelImpl
import com.dong.kotlin.first.view.LoginView

/**
 * @packInfo:com.dong.kotlin.first.presenter
 * @author: yadong.qiu
 * Created by 邱亚东
 * Date: 2018/10/22
 * Time: 14:47
 */
class LoginPresenterImpl(val loginView:LoginView):LoginPresenter,LoginPresenter.onLoginListener,LoginPresenter.onRegisterListener {

    val mLoginModel:LoginModel

    init {
        mLoginModel = LoginModelImpl()
    }


    override fun login(username: String, password: String) {
        mLoginModel.login(this,username,password)
    }

    override fun loginSuccess(result: LoginResponse) {
        loginView.loginSuccess(result)
    }

    override fun loginFailed(message: String) {
        loginView.loginFailed(message)
    }



    override fun register(username: String, password: String, email: String) {
        mLoginModel.register(this,username,password,email)
    }

    override fun registerSuccess(result: RegisterResponse) {
        loginView.registerSuccess(result)
    }

    override fun registerFailed(message: String?) {
        loginView.registerFailed(message)
    }
}