package com.example.wanandroid.net

import com.example.wanandroid.util.IRequestUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    private constructor() {
        retrofit = Retrofit.Builder()
            .baseUrl(IRequestUrl.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }

    companion object{
        private lateinit var retrofit: retrofit2.Retrofit
        fun getInstance():RetrofitClient = RetrofitClientHelper.INSTANCE
    }

    fun <T> create(service:Class<T>):T{
        return retrofit.create(service)
    }

    private object RetrofitClientHelper{
        val INSTANCE:RetrofitClient = RetrofitClient()
    }
}