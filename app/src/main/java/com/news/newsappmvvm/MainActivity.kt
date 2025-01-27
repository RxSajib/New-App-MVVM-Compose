package com.news.newsappmvvm

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.splashscreen.SplashScreen.KeepOnScreenCondition
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.news.newsappmvvm.presentation.onboardingscreen.component.OnBoardPage
import com.news.newsappmvvm.presentation.onboardingscreen.component.OnBoardingScreen
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.AppEntryUseCase
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.navigation.NavGraph
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.onboarding.MainViewModel
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.onboarding.OnBoardingViewModel
import com.news.newsappmvvm.ui.theme.NewsAppMVVMTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MainActivity"
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewmodel by viewModels<MainViewModel>()

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

