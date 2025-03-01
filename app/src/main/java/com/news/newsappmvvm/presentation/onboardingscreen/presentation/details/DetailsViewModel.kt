package com.news.newsappmvvm.presentation.onboardingscreen.presentation.details

import androidx.lifecycle.ViewModel
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.news.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase
) : ViewModel() {
}