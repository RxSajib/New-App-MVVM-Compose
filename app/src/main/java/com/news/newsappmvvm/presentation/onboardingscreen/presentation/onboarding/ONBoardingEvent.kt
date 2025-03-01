package com.news.newsappmvvm.presentation.onboardingscreen.presentation.onboarding

sealed class ONBoardingEvent {

    data object SaveAppEntry : ONBoardingEvent()

}