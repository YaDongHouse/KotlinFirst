package com.dong.kotlin.first.api

import com.dong.kotlin.first.bean.LoginResponse
import com.dong.kotlin.first.bean.RegisterResponse
import com.dong.kotlin.first.constant.Constant
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @packInfo:com.dong.kotlin.first.api
 * @author: yadong.qiu
 * Created by 邱亚东
 * Date: 2018/10/22
 * Time: 11:30
 */
interface RetrofitService {


    /**
     * 注册
     * key 用户申请的appkey
     * username：用户名（一个key只能存在唯一username）
     * password：用户密码（建议加密）
     * email：邮箱
     */
   @GET("rigister")
    fun userRegister(
           @Query("username") userName:String,
           @Query("password") password:String,
           @Query("email") email:String,
           @Query("key") key:String = Constant.KEY
   ):Observable<RegisterResponse>

    @GET("login")
    fun userLogin(
            @Query("username") username:String,
            @Query("password") password:String,
            @Query("key") key:String = Constant.KEY
    ):Observable<LoginResponse>

}