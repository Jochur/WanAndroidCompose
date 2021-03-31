package com.example.wanandroid.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wanandroid.R
import com.example.wanandroid.bean.ArticleInfo
import com.example.wanandroid.viewmodel.MainViewModel

@Composable
fun HomeScreen(mainViewModel: MainViewModel){
    val homePage = mainViewModel.homePage
    val dates  by homePage.observeAsState()
//    Log.e("zhouzhu","datas:"+dates.toString())
    val data = dates?.datas
    if(data == null){
        Column(
            Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.page_bg))) {
            Text(text = "加载中，请稍等。。。")
        }
    }else {
        val lazyState = rememberLazyListState()
        LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)
            ,modifier = Modifier.background(color = colorResource(id = R.color.page_bg)),
            state = lazyState) {
            item {
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp))
            }
            items(data!!.size) { item ->
                ArticleItem(articleInfo = data[item])
            }
            item {
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp))
            }
        }
    }
}

@Composable
fun ArticleItem(articleInfo: ArticleInfo){
    val image = painterResource(id = R.mipmap.entry_zan_unsel)
    Box(
        Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(horizontal = 10.dp)
            .background(
                colorResource(id = R.color.all_bg), shape = RoundedCornerShape(10.dp)
            ),
            contentAlignment = Alignment.CenterStart) {
        Image(painter = image,
            contentDescription = "图片",
            modifier = Modifier
                .width(40.dp),
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(start = 45.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)) {

            Text(text = articleInfo.title,maxLines = 2
                ,overflow = TextOverflow.Ellipsis,fontSize = 16.sp,
                color = colorResource(id = R.color.art_title))

            Text(text = articleInfo.desc, maxLines = 1,
                overflow = TextOverflow.Ellipsis,fontSize = 14.sp,
                color = colorResource(id = R.color.art_desc),
                modifier = Modifier.padding(vertical = 6.dp))

            Text(text = "作者："+articleInfo.author, maxLines = 1,
                overflow = TextOverflow.Ellipsis,fontSize = 14.sp,
                color = colorResource(id = R.color.art_desc),
                modifier = Modifier.padding(vertical = 6.dp))

            Row {
                Text(text = articleInfo.chapterName+"|"+articleInfo.superChapterName,fontSize = 12.sp
                , color = colorResource(id = R.color.art_type))
                Text(text = articleInfo.niceDate,fontSize = 12.sp
                    , color = colorResource(id = R.color.art_type)
                    ,modifier = Modifier.fillMaxWidth(),textAlign = TextAlign.Right)
            }

        }


    }
}
