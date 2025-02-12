package com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.app_entry

import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAppEntry @Inject constructor(
    private val localUserManager: LocalUserManager
) {

    operator fun invoke() : Flow<Boolean> = localUserManager.getAppEntry()
}