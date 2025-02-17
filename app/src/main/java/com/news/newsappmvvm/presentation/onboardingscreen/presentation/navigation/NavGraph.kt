package com.news.newsappmvvm.presentation.onboardingscreen.presentation.navigation

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.news.newsappmvvm.presentation.onboardingscreen.component.OnBoardingScreen
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.bookmark.BookMarkScreen
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.bookmark.BookMarkViewModel
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.home.HomeScreen
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.home.HomeViewModel
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.onboarding.OnBoardingViewModel

private const val TAG = "NavGraph"
@Composable
fun NavGraph(
    startDestination : String,
) {
    val viewmodel: OnBoardingViewModel = hiltViewModel()
    val x : HomeViewModel = hiltViewModel()
    val bookMarkVM : BookMarkViewModel = hiltViewModel()

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        navigation(route = Route.AppStartNavigation.route, startDestination = Route.OnBoardingScreen.route ){
            composable(route = Route.OnBoardingScreen.route){
                OnBoardingScreen(event = viewmodel::onEvent)
            }
        }

        navigation(route = Route.NewsNavigation.route, startDestination = Route.NewsNavigatorScreen.route){
            composable(route = Route.NewsNavigatorScreen.route){
                val articls = x.getNews.collectAsLazyPagingItems()
                HomeScreen(articles = articls, navigate = {})
           //     Log.d(TAG, "NavGraph: ${bookMarkVM.state.value.list.size}")
         //       BookMarkScreen(bookMarkState = bookMarkVM.state.value, navigator = {})
            }
        }
    }
}