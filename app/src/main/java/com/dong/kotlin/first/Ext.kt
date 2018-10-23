package com.dong.kotlin.first

import android.util.Log

/**
 * @packInfo:com.dong.kotlin.first
 * @author: yadong.qiu
 * Created by 邱亚东
 * Date: 2018/10/22
 * Time: 14:34
 */
fun loge(tag:String,content:String){
    Log.e(tag,content?:tag)
}