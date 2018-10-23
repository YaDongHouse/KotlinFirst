package com.dong.kotlin.first.model

import com.dong.kotlin.first.presenter.LoginPresenter
import com.dong.kotlin.first.util.RetrofitUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @packInfo:com.dong.kotlin.first.model
 * @author: yadong.qiu
 * Created by 邱亚东
 * Date: 2018/10/22
 * Time: 14:55
 */
class LoginModelImpl : LoginModel {

    var mOnLoginListener: LoginPresenter.onLoginListener? = null
    var mOnRegisterListener: LoginPresenter.onRegisterListener? = null

    override fun login(onLoginListener: LoginPresenter.onLoginListener, username: String, password: String) {
        if (mOnLoginListener == null) {
            mOnLoginListener = onLoginListener
        }
        RetrofitUtils
                .retrofitService
                .userLogin(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->
                            when (result.retCode) {
                                "200" ->
                                    mOnLoginListener!!.loginSuccess(result)
                                else ->
                                    mOnLoginListener!!.loginFailed(result.msg)
                            }
                        }, { error ->
                    mOnLoginListener!!.loginFailed(error.message ?: "未知错误")
                })

    }


    override fun register(onRegisterListener: LoginPresenter.onRegisterListener, username: String, password: String, email: String) {
        if (mOnRegisterListener == null) {
            mOnRegisterListener = onRegisterListener
        }
        RetrofitUtils
                .retrofitService
                .userRegister(username, password, email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->
                            when (result.retCode) {
                                "200" ->
                                    mOnRegisterListener!!.registerSuccess(result)
                                else ->
                                    mOnRegisterListener!!.registerFailed(result.msg)
                            }
                        }, { error ->
                    mOnRegisterListener!!.registerFailed(error.message ?: "未知错误")
                })


    }

}