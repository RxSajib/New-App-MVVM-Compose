package com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.news

import androidx.paging.PagingData
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.model.Article
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(sources : List<String>) : Flow<PagingData<Article>> =
        newsRepository.getNews(sources)
}