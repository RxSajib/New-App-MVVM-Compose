package com.news.newsappmvvm.presentation.onboardingscreen.component.di

import android.content.Context
import com.news.newsappmvvm.presentation.onboardingscreen.component.data.manager.LocalUserManagerImp
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.manager.LocalUserManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context) : LocalUserManager = LocalUserManagerImp(context = context)
}