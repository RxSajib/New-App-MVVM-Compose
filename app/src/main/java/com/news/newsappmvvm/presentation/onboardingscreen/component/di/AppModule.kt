package com.news.newsappmvvm.presentation.onboardingscreen.component.di

import android.content.Context
import com.news.newsappmvvm.presentation.onboardingscreen.component.data.manager.LocalUserManagerImp
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.manager.LocalUserManager
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.AppEntryUseCase
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.GetAppEntry
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.SaveAppEntry
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

    @Provides
    @Singleton
    fun provideDataStoreModel(localUserManager: LocalUserManager) : AppEntryUseCase =
        AppEntryUseCase(
            saveAppEntry = SaveAppEntry(localUserManager = localUserManager),
            getAppEntry = GetAppEntry(localUserManager = localUserManager)
        )
}