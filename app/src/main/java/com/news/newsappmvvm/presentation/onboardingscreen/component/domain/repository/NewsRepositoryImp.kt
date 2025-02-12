package com.news.newsappmvvm.presentation.onboardingscreen.component.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.news.newsappmvvm.presentation.onboardingscreen.component.data.remote.NewsAPI
import com.news.newsappmvvm.presentation.onboardingscreen.component.data.remote.NewsPagingSource
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.model.Article
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImp(
    private val newsAPI: NewsAPI
) : NewsRepository {
    override fun getNews(source: List<String>): Flow<PagingData<Article>> {
     return  Pager(
            config = PagingConfig(
                pageSize = 10,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                NewsPagingSource(api = newsAPI, source = source.joinToString(separator = ","))
            }
        ).flow
    }
}