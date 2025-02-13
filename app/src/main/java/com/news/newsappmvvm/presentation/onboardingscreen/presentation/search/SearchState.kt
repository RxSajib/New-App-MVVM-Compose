package com.news.newsappmvvm.presentation.onboardingscreen.presentation.search

import androidx.paging.PagingData
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery : String = "",
    val articles : Flow<PagingData<Article>>? = null
)