package com.news.newsappmvvm.presentation.onboardingscreen.component.domain.model


import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "ArticleDB")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val articleID : Int = 0,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)