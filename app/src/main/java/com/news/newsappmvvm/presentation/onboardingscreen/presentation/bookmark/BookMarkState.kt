package com.news.newsappmvvm.presentation.onboardingscreen.presentation.bookmark

import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.model.Article

data class BookMarkState(
    val list : List<Article> = emptyList()
)
