package com.example.wanandroid.service

import com.example.wanandroid.bean.BaseResponse
import com.example.wanandroid.bean.HomePageBean
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface HomeApi {

    @GET("/article/list/{pageNum}/json")
    suspend fun getHomePageInfo(@Path("pageNum") pageNum:Int) : BaseResponse<HomePageBean>

}