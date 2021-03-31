package com.example.wanandroid.service

import com.example.wanandroid.bean.BaseResponse
import com.example.wanandroid.bean.HomePageBean
import com.example.wanandroid.net.RetrofitClient

class HomeRepository private constructor(private val homeApi: HomeApi) {


    suspend fun getHomePage(pageNum:Int):BaseResponse<HomePageBean>{
        return homeApi.getHomePageInfo(pageNum)
    }

    companion object{
        val instance:HomeRepository by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            HomeRepository(RetrofitClient.getInstance().create(HomeApi::class.java))
        }
    }
}