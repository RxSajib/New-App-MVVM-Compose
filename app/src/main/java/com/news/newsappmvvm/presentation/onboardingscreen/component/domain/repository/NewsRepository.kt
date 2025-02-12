package com.news.newsappmvvm.presentation.onboardingscreen.component.domain.repository

import androidx.paging.PagingData
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(source : List<String>) : Flow<PagingData<Article>>
}