package com.news.newsappmvvm.presentation.onboardingscreen.component.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.model.Article

@Database(entities = [Article::class], version = 4, exportSchema = false)
@TypeConverters(SourceTypeConverter::class)
abstract class ArticleDatabase : RoomDatabase(){

    abstract fun getDao() : ArticleDao
}