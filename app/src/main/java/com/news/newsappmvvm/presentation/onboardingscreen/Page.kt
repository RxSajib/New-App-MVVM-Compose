package com.news.newsappmvvm.presentation.onboardingscreen

import androidx.annotation.DrawableRes
import com.news.newsappmvvm.R

data class Page(
    val title : String,
    val details : String,
    @DrawableRes val image : Int
)

val pages = listOf(
    Page(
        title = "News for today",
        details = "On top of the servers being full or just going offline completely, it appears that there’s an issue with the game’s Dynasty Mode as well",
        image = R.drawable.logo
    ),

    Page(
        title = "News for today",
        details = "Lorem Ipsum has reared its ugly head and interrupted what was meant to be a glorious day of college football",
        image = R.drawable.logo
    ),

    Page(
        title = "News for today",
        details = "Lorem Ipsum has reared its ugly head and interrupted what was meant to be a glorious day of college football",
        image = R.drawable.logo
    )

)
