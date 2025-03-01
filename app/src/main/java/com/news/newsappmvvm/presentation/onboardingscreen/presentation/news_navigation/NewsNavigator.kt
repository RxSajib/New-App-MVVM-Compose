package com.news.newsappmvvm.presentation.onboardingscreen.presentation.news_navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.news.newsappmvvm.R
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.bookmark.BookMarkScreen
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.home.HomeScreen
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.home.HomeViewModel
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.navigation.Route
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.news_navigation.component.BottomNavigationItem
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.news_navigation.component.NewsBottomNavigation

@Composable
fun NewsNavigator() {

    val bottomNavigationItem = remember {
        listOf(
            BottomNavigationItem(
                icon = R.drawable.home_svgrepo_com,
                text = "Home"
            ),
            BottomNavigationItem(
                icon = R.drawable.search_alt_svgrepo_com,
                text = "Search"
            ), BottomNavigationItem(
                icon = R.drawable.bookmark_svgrepo_com,
                text = "BookMark"
            )
        )
    }

    val navcontroller = rememberNavController()
    val backStack = navcontroller.currentBackStackEntryAsState().value
    var selectedIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    selectedIndex = when (backStack?.destination?.route) {
        Route.HomeScreen.route -> 0
        Route.SearchScreen.route -> 1
        Route.BookMarkScreen.route -> 2
        else -> 0
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),

        bottomBar = {
            NewsBottomNavigation(
                items = bottomNavigationItem,
                selected = selectedIndex,
                onItemClick = { index ->
                    when (index) {
                        0 -> navigatedTop(
                            navController = navcontroller,
                            route = Route.HomeScreen.route
                        )

                        1 -> navigatedTop(
                            navController = navcontroller,
                            route = Route.SearchScreen.route
                        )

                        2 -> navigatedTop(
                            navController = navcontroller,
                            route = Route.BookMarkScreen.route
                        )
                    }
                })
        }

    ) { innderpadding ->
        val bottomPadding = innderpadding.calculateBottomPadding()
        NavHost(
            navcontroller,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            composable(route = Route.SearchScreen.route){
               // SearchScreen()
                Box(modifier = Modifier.fillMaxSize()) {
                    Text("Search")
                }
            }

            composable(route = Route.HomeScreen.route){
               /* HomeScreen( navigate = {
                }, articles = )*/
            }

            composable(route = Route.BookMarkScreen.route) {

                BookMarkScreen()
            }
        }
    }
}

fun navigatedTop(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { homeScreen ->
            popUpTo(homeScreen) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}