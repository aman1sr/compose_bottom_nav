package com.pahadi.composebottomnav.base

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import com.pahadi.composebottomnav.R

enum class Route(@StringRes val title: Int, val icon: Int){
    TopNews(title = R.string.nav_top_news, icon = R.drawable.ic_news),
    FilterNews(title = R.string.nav_filter_news, icon = R.drawable.ic_filter),
    SavedNews(title = R.string.nav_saved_news, icon = R.drawable.ic_save),
    SearchNews(title = R.string.nav_search_news, icon = R.drawable.ic_search)
}

val bottomScreenList = listOf(
    Route.TopNews,
    Route.FilterNews,
    Route.SavedNews,
    Route.SearchNews
)