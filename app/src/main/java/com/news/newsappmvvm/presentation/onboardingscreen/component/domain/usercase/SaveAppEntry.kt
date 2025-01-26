package com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase

import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.manager.LocalUserManager
import javax.inject.Inject

class SaveAppEntry @Inject constructor(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}