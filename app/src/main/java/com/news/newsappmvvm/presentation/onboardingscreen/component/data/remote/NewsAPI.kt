package com.news.newsappmvvm.presentation.onboardingscreen.component.data.remote

import com.news.newsappmvvm.presentation.onboardingscreen.component.data.DataManager
import com.news.newsappmvvm.presentation.onboardingscreen.component.data.remote.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("everything")
    suspend fun getNews(
        @Query("q") search : String,
        @Query("page") page : Int,
        @Query("apiKey") apiKey : String = DataManager.API_KEY
    ) : NewsResponse
}