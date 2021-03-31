package com.example.wanandroid.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wanandroid.BottomButtonBean
import com.example.wanandroid.R
import com.example.wanandroid.bean.BaseResponse
import com.example.wanandroid.bean.HomePageBean
import com.example.wanandroid.service.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainViewModel : ViewModel(){
    val buttons = listOf<BottomButtonBean>(BottomButtonBean("首页",R.mipmap.entry_home_sel,R.mipmap.entry_home_unsel)
        , BottomButtonBean("导航",R.mipmap.entry_navigation_sel,R.mipmap.entry_navigation_unsel)
        , BottomButtonBean("体系",R.mipmap.entry_system_sel,R.mipmap.entry_system_unsel)
        , BottomButtonBean("项目",R.mipmap.entry_project_sel,R.mipmap.entry_project_unsel))

    private val _selIndex = MutableLiveData<Int>(0)
    val selIndex:LiveData<Int> = _selIndex

    fun changeSelIndex(newIndex:Int){
        if(newIndex<buttons.size) {
            _selIndex.value = newIndex
        }
    }

    private val _homePage = MutableLiveData<HomePageBean>()
    val homePage:LiveData<HomePageBean> = _homePage

    fun loadHomePage(pageNum:Int){
        Log.e("zhouzhu","jin ru")
        viewModelScope.launch(Dispatchers.Main) {
            try {
                val data = HomeRepository.instance.getHomePage(pageNum = pageNum)
                Log.e("zhouzhu",data.toString())
                _homePage.value = data.data()

            } catch (e:Exception){
                Log.e("zhouzhu",e.message.toString())
            }
        }
    }



}