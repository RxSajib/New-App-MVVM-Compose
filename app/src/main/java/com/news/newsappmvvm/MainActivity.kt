package com.news.newsappmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.news.newsappmvvm.presentation.onboardingscreen.component.data.local.ArticleDao
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.model.Article
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.navigation.NavGraph
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.onboarding.MainViewModel
import com.news.newsappmvvm.ui.theme.NewsAppMVVMTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MainActivity"
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewmodel by viewModels<MainViewModel>()
    @Inject lateinit var dao: ArticleDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewmodel.sp
            }
        }




        enableEdgeToEdge()
        setContent {
            NewsAppMVVMTheme {

                val isSystemInDarkMode = isSystemInDarkTheme()
                val systemControllerColor = rememberSystemUiController()

                SideEffect {
                    systemControllerColor.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = !isSystemInDarkMode
                    )
                }

                val start = viewmodel.startDes
                NavGraph(start)
            }
        }
    }
}

