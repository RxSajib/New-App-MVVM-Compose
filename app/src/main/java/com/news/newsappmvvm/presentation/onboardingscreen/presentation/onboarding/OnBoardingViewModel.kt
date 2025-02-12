package com.news.newsappmvvm.presentation.onboardingscreen.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.app_entry.AppEntryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appEntryUseCase: AppEntryUseCase
) : ViewModel() {

    fun onEvent(event: ONBoardingEvent){
        when(event){
            is ONBoardingEvent.SaveAppEntry -> {
                saveAppEntry()
            }
        }
    }

    private fun saveAppEntry(){
        viewModelScope.launch {
            appEntryUseCase.saveAppEntry()
        }
    }
}