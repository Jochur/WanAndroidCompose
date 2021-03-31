package com.example.wanandroid.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.wanandroid.BottomButtonBean
import com.example.wanandroid.R
import com.example.wanandroid.ui.HomeScreen
import com.example.wanandroid.ui.theme.WanAndroidTheme
import com.example.wanandroid.viewmodel.MainViewModel
import kotlinx.coroutines.launch

@Composable
fun MainContent(mainViewModel: MainViewModel) {
    WanAndroidTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            MainScaffold(mainViewModel = mainViewModel)
        }
    }
}

@Composable
fun MainScaffold(mainViewModel: MainViewModel,
                 scaffoldState: ScaffoldState = rememberScaffoldState()){
    val coroutineScope = rememberCoroutineScope()
    val bottomBtn = mainViewModel.buttons
    val index by mainViewModel.selIndex.observeAsState()
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            AppDrawer(mainViewModel = mainViewModel)
        },
        topBar = {
            TopAppBar(
                title = {
                    bottomBtn[index!!]?.title?.let { Text(text = it,color = Color.White) }
                        },
                navigationIcon = {
                    IconButton(onClick = { coroutineScope.launch { scaffoldState.drawerState.open() } }) {
                        Icon(painter = painterResource(id = R.drawable.abc_vector_test)
                            , contentDescription = "open or close the drawer" )
                    }
                },
                backgroundColor = colorResource(id = R.color.all_bg)
            )
        },
        content = {
            when(index){
                0 -> HomeScreen(mainViewModel)
                1 -> NavigationScreen(mainViewModel)
                2 -> SystemScreen(mainViewModel)
                3 -> ProjectScreen(mainViewModel)
                else -> HomeScreen(mainViewModel)
            }
        },
        bottomBar = {
            index?.let { SetBottomBar(bottomBtn = bottomBtn, index = it, mainViewModel = mainViewModel) }
        }
    )
}

@Composable
fun SetBottomBar(bottomBtn:List<BottomButtonBean>,index:Int,mainViewModel: MainViewModel){
    BottomAppBar(
        Modifier
            .fillMaxWidth()
            .height(60.dp),
        backgroundColor = colorResource(id = R.color.white),
        contentPadding = PaddingValues(0.dp),
        ) {
        BottomNavigation(
            Modifier
                .fillMaxWidth()
                .height(60.dp),
            backgroundColor = colorResource(id = R.color.white)
                ) {
            for((pos,btnBean) in bottomBtn.withIndex()){
                BottomNavigationItem(
                    selected = index == pos
                    ,onClick = { mainViewModel.changeSelIndex(pos) }
                    ,label = { Text(text = btnBean.title,color = if(index == pos) colorResource(id = R.color.all_bg) else colorResource(id = R.color.black))}
                    ,selectedContentColor = colorResource(id = R.color.all_bg)
                    ,unselectedContentColor = colorResource(id = R.color.black)
                    ,icon = {
                        val painter = painterResource(id = if(index == pos) btnBean.selIcon else btnBean.unSelIcon)
                        Icon(painter = painter, contentDescription = null,
                            Modifier
                                .width(30.dp)
                                .height(30.dp))
                    }
                )
            }
        }
    }
}
