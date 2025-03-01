package com.news.newsappmvvm.presentation.onboardingscreen.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.news.newsappmvvm.presentation.onboardingscreen.component.OnBoardingScreen
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.home.HomeScreen
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.home.HomeViewModel
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.news_navigation.NewsNavigator
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.onboarding.OnBoardingViewModel

private const val TAG = "NavGraph"

@Composable
fun NavGraph(
    startDestination: String,
) {
    val viewmodel: OnBoardingViewModel = hiltViewModel()
    val homeViewModel: HomeViewModel = hiltViewModel()

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                OnBoardingScreen(event = viewmodel::onEvent)
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(route = Route.NewsNavigatorScreen.route) {
             //
             //   HomeScreen(navigate = {}, homeViewModel = homeViewModel)
                HomeScreen(navigate = {

                }, homeViewModel)
            }
        }
    }
}