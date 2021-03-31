package com.example.wanandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.wanandroid.ui.main.MainContent
import com.example.wanandroid.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainViewModel by viewModels<MainViewModel>()
        mainViewModel.loadHomePage(0)
        setContent {
            MainContent(mainViewModel)
        }
    }
}
