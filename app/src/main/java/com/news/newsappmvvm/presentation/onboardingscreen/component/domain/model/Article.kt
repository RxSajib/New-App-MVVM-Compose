package com.news.newsappmvvm.presentation.onboardingscreen.component.domain.model


import androidx.annotation.Keep

@Keep
data class Article(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)