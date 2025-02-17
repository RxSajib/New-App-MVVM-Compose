package com.news.newsappmvvm.presentation.onboardingscreen.component.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.model.Source

class SourceTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromSource(source: Source?): String {
        return gson.toJson(source)
    }

    @TypeConverter
    fun toSource(sourceString: String): Source? {
        return gson.fromJson(sourceString, object : TypeToken<Source?>() {}.type)
    }
}