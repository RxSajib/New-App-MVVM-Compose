package com.news.newsappmvvm.presentation.onboardingscreen.presentation.onboarding

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.AppEntryUseCase
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

private const val TAG = "MainViewModel"
@HiltViewModel
class MainViewModel @Inject constructor(
     appEntryUseCase: AppEntryUseCase
) : ViewModel() {

    var sp by mutableStateOf(true)
        private set


    var startDes by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        appEntryUseCase.getAppEntry().onEach {
            if(it){
                startDes = Route.NewsNavigation.route
                Log.d(TAG, "news")
            }else {
                startDes = Route.AppStartNavigation.route
                Log.d(TAG, "splash")
            }

            delay(300)
            sp = false
        }.launchIn(viewModelScope)
    }
}