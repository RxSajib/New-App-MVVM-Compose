package com.news.newsappmvvm.presentation.onboardingscreen.component.data.remote.dto


import androidx.annotation.Keep
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.model.Article

@Keep
data class NewsResponse(
    val articles: List<Article>,
    val status: String?,
    val totalResults: Int?
)