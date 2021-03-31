package com.example.wanandroid.bean

data class BaseResponse<T>(
    val errorMsg: String,
    val errorCode: Int,
    val data: T
){
    fun code() = errorCode

    fun msg() = errorMsg

    fun data() = data

    fun isSuccess() = errorCode == 0
}
