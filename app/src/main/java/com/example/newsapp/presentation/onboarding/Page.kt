package com.example.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.newsapp.R

data class Page (
    val title :String ,
    val description :String ,
    @DrawableRes val image :Int ,
)

val pages = listOf(
    Page(
        title = "News Application" ,
        description = "news Application its a simple clean architecture MVVM & MVI app" ,
        image = R.drawable.logo
    ) ,
    Page(
        title = "News Application" ,
        description = "news Application its a simple clean architecture MVVM & MVI app" ,
        image = R.drawable.logo
    ) ,
    Page(
        title = "News Application" ,
        description = "news Application its a simple clean architecture MVVM & MVI app" ,
        image = R.drawable.logo
    )
)