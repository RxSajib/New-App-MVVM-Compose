package com.news.newsappmvvm.presentation.onboardingscreen.presentation.bookmark

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.news.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

private const val TAG = "BookMarkViewModel"
@HiltViewModel
class BookMarkViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(BookMarkState())
    val state : State<BookMarkState> = _state

    init {
        getArticles()
    }

    private fun getArticles(){
        newsUseCase.getArticles().onEach {
            _state.value = _state.value.copy(it)
        }.launchIn(viewModelScope)
    }
}