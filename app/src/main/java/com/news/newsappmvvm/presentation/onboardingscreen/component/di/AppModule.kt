package com.news.newsappmvvm.presentation.onboardingscreen.component.di

import android.content.Context
import androidx.room.Room
import com.news.newsappmvvm.presentation.onboardingscreen.component.data.DataManager
import com.news.newsappmvvm.presentation.onboardingscreen.component.data.local.ArticleDao
import com.news.newsappmvvm.presentation.onboardingscreen.component.data.local.ArticleDatabase
import com.news.newsappmvvm.presentation.onboardingscreen.component.data.local.SourceTypeConverter
import com.news.newsappmvvm.presentation.onboardingscreen.component.data.manager.LocalUserManagerImp
import com.news.newsappmvvm.presentation.onboardingscreen.component.data.remote.NewsAPI
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.manager.LocalUserManager
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.repository.NewsRepository
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.repository.NewsRepositoryImp
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.app_entry.AppEntryUseCase
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.app_entry.GetAppEntry
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.app_entry.SaveAppEntry
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.news.DeleteArticles
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.news.GetArticles
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.news.GetNews
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.news.NewsUseCase
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.news.SearchNews
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.news.UpsertArticles
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl(DataManager.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    @Singleton
    fun provideAPI(retrofit: Retrofit): NewsAPI =
        retrofit.create(NewsAPI::class.java)

    @Provides
    @Singleton
    fun provideNewsRepository(newsAPI: NewsAPI): NewsRepository = NewsRepositoryImp(
        newsAPI = newsAPI
    )

    @Provides
    @Singleton
    fun provideNewsUseCase(newsRepository: NewsRepository, dao: ArticleDao): NewsUseCase = NewsUseCase(
        getNews = GetNews(newsRepository = newsRepository),
        searchNews = SearchNews(newsRepository = newsRepository),
        upsertArticles = UpsertArticles(dao = dao),
        deleteArticles = DeleteArticles(dao = dao),
        getArticles = GetArticles(dao = dao)
    )


    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context): LocalUserManager =
        LocalUserManagerImp(context = context)

    @Provides
    @Singleton
    fun provideDataStoreModel(localUserManager: LocalUserManager): AppEntryUseCase =
        AppEntryUseCase(
            saveAppEntry = SaveAppEntry(localUserManager = localUserManager),
            getAppEntry = GetAppEntry(localUserManager = localUserManager)
        )


    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : ArticleDatabase =
        Room.databaseBuilder(context = context, ArticleDatabase::class.java, "ArticleDatabase")
            .fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideDao(articleDatabase: ArticleDatabase) : ArticleDao = articleDatabase.getDao()
}