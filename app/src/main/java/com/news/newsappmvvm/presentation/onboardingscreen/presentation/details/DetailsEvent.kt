package com.news.newsappmvvm.presentation.onboardingscreen.presentation.details

sealed class DetailsEvent {

    data object SaveArticlesEvent : DetailsEvent()
}