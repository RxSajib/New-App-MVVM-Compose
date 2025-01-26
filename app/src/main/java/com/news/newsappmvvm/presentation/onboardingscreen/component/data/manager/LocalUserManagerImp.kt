package com.news.newsappmvvm.presentation.onboardingscreen.component.data.manager

import android.content.Context
import androidx.compose.ui.unit.Constraints
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.manager.LocalUserManager
import com.news.newsappmvvm.presentation.onboardingscreen.component.utils.Constant.Constant
import com.news.newsappmvvm.presentation.onboardingscreen.component.utils.Constant.Constant.USER_SETTING
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImp(private val context: Context) : LocalUserManager {
    override suspend fun saveAppEntry() {
        context.dataStore.edit { dataStore ->
            dataStore[PreferencesKeys.APP_ENTRY] = true
        }
    }

    override fun getAppEntry(): Flow<Boolean> {
      return  context.dataStore.data.map { dataStore ->
            dataStore[PreferencesKeys.APP_ENTRY] ?: false
        }
    }
}

private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = USER_SETTING)

private object PreferencesKeys{
    val APP_ENTRY = booleanPreferencesKey(name = Constant.APP_ENTRY)
}