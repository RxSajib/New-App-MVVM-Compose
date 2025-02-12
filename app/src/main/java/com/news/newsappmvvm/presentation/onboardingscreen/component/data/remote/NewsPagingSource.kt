package com.news.newsappmvvm.presentation.onboardingscreen.component.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.model.Article

const val PAGE_FIRST_INDEX = 1
class NewsPagingSource(
    private val api: NewsAPI,
    private val source: String
) : PagingSource<Int, Article>() {

    private var totalNewsCount = 0

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: PAGE_FIRST_INDEX
        return try {
            val newsResponse = api.getNews(search = source, page = page)
            totalNewsCount += newsResponse.articles.size
            val articls = newsResponse.articles.distinctBy { it.title }

            LoadResult.Page(
                data = articls,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1,
                prevKey = null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}