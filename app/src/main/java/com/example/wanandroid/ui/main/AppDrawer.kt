package com.example.wanandroid.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import com.example.wanandroid.viewmodel.MainViewModel

@Composable
fun AppDrawer(mainViewModel: MainViewModel) {
    Column(Modifier.fillMaxSize()) {
        Text(text = "我是抽屉")
    }
}