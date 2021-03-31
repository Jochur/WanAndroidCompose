package com.example.wanandroid.bean

data class HomePageBean(var curPage:Int,var datas:List<ArticleInfo>,
                        var offset:Int,var over:Boolean,
                        var pageCount:Int,var size:Int,
                        var total:Int)
