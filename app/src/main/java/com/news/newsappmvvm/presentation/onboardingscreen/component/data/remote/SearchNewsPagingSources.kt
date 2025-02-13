package com.news.newsappmvvm.presentation.onboardingscreen.component.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.model.Article

const val FIRST_INDEX = 1
class SearchNewsPagingSources constructor(
    private val api: NewsAPI,
    private val search : String
) : PagingSource<Int, Article> (){

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
            val newsResponse = api.searchNews(search = search, page = page)
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