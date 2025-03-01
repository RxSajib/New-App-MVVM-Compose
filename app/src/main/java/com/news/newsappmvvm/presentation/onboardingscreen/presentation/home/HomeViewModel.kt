package com.news.newsappmvvm.presentation.onboardingscreen.presentation.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.news.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val getNews = newsUseCase.getNews(
        sources = listOf("A", "B", "C")
    ).cachedIn(scope = viewModelScope)
}