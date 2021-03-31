package com.example.wanandroid.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.wanandroid.viewmodel.MainViewModel

@Composable
fun SystemScreen(mainViewModel: MainViewModel){
    Column(Modifier.fillMaxSize()) {
        Text(text = "体系")
    }
}