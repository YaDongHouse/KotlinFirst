package com.dong.kotlin.first

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import cn.pedant.SweetAlert.SweetAlertDialog
import com.dong.kotlin.first.bean.LoginResponse
import com.dong.kotlin.first.bean.RegisterResponse
import com.dong.kotlin.first.presenter.LoginPresenter
import com.dong.kotlin.first.presenter.LoginPresenterImpl
import com.dong.kotlin.first.view.LoginView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity(), View.OnClickListener,LoginView {

    var loginPresenter:LoginPresenter? = null
    var dialog:SweetAlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginPresenter = LoginPresenterImpl(this)
        user_login.setOnClickListener(this)
        user_register.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.user_login -> {
                if (checkContent(true)) {
                    dialog = SweetAlertDialog(this,SweetAlertDialog.PROGRESS_TYPE)
                            .setTitleText("正在登陆...")
                    dialog!!.setCancelable(false)
                    dialog!!.show()
                    loginPresenter!!.login(user_name.text.toString(),user_pass.text.toString())
                }
            }
            R.id.user_register -> {
                if (checkContent(false)) {
                    dialog = SweetAlertDialog(this,SweetAlertDialog.PROGRESS_TYPE)
                            .setTitleText("正在注册...")
                    dialog!!.setCancelable(false)
                    dialog!!.show()
                    loginPresenter!!.register(user_name.text.toString(),user_pass.text.toString(),user_email.text.toString())
                }
            }
        }
    }



    override fun loginSuccess(result: LoginResponse) {
        dialog!!.changeAlertType(SweetAlertDialog.SUCCESS_TYPE)
        dialog!!.titleText = result.msg
    }

    override fun loginFailed(message: String) {
        dialog!!.changeAlertType(SweetAlertDialog.ERROR_TYPE)
        dialog!!.titleText = message
    }

    override fun registerSuccess(result: RegisterResponse) {
        dialog!!.changeAlertType(SweetAlertDialog.SUCCESS_TYPE)
        dialog!!.titleText = result.msg
    }

    override fun registerFailed(message: String?) {
        dialog!!.changeAlertType(SweetAlertDialog.ERROR_TYPE)
        dialog!!.titleText = message
    }

    /**
     * 内容做判断
     */
    private fun checkContent(login:Boolean):Boolean{
        user_name.error = null
        user_pass.error = null
        user_email.error = null

        var cancel = false
        var focusView:View? = null

        if (!login) {
            if (TextUtils.isEmpty(user_email.toString())){
                user_email.error = "Email不能为空"
                focusView = user_email
                cancel = true
            }else if (!isEmail(user_email.text.toString())){
                user_email.error = "Email格式不正确"
                focusView = user_email
                cancel = true
            }
        }

        if (TextUtils.isEmpty(user_pass.text.toString())){
            user_pass.error = "密码不能为空"
            focusView = user_pass
            cancel = true
        } else if (user_pass.text.length < 6){
            user_pass.error = "密码长度不能小于6位"
            focusView = user_pass
            cancel = true
        }

        if (TextUtils.isEmpty(user_name.text.toString())){
            user_name.error = "用户名不能为空"
            focusView = user_name
            cancel = true
        }

        if (cancel){
            if (focusView!=null){
                focusView.requestFocus()
            }
        } else {
            return true
        }
        return false
    }

    /**
     * 判断email地址
     */
    fun isEmail(email:String):Boolean{
        if (email == null){
            return false
        }
        val regex = "\\w+@(\\w{2,3})(\\.\\w+)"
        val pattern = Pattern.compile(regex)
        return pattern.matcher(email).matches()

    }


}
