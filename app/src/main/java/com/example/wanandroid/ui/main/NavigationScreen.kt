package com.example.wanandroid.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.wanandroid.R
import com.example.wanandroid.viewmodel.MainViewModel

@Composable
fun NavigationScreen(mainViewModel: MainViewModel){
    var state = remember { mutableStateOf(0) }
    val titles = listOf("标签1", "标签2", "这是很长的标签3")
    Column(
        Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.page_bg))) {

        ScrollableTabRow(selectedTabIndex = state.value,
            backgroundColor = colorResource(id = R.color.all_bg),
            contentColor = colorResource(id = R.color.white),
            edgePadding = 0.dp
        ) {
            titles.forEachIndexed{index, title ->
                Tab(selected = state.value == index,
                    onClick = { state.value = index },
                    text = { Text(text = title)},
                    modifier = Modifier.width(200.dp),
                    unselectedContentColor = colorResource(id = R.color.art_desc),
                    selectedContentColor = colorResource(id = R.color.white)
                    )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        LazyRow(modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.black))) {
            item(){
                Column(modifier = Modifier
                    .fillMaxWidth().fillMaxHeight()
                    .background(color = colorResource(id = R.color.status_bar))) {
                    Text(
                        text = "第${1}个标签被选中了:${titles[0]}",
                        style = MaterialTheme.typography.body1
                    )
                }

            }
        }

    }
}