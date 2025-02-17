package com.news.newsappmvvm.presentation.onboardingscreen.presentation.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.news.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(SearchState())

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.updateSearchQuery -> {
                _state.value = _state.value.copy(searchQuery = event.searchQuery)
            }

            is SearchEvent.searchNews -> {
                searchName()
            }
        }

    }

    private fun searchName(){
        /*val articles = newsUseCase.searchNews(

        )*/
    }

}