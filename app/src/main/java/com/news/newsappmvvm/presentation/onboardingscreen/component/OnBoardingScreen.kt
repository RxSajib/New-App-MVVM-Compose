package com.news.newsappmvvm.presentation.onboardingscreen.component

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.news.newsappmvvm.Dimens.MediumPadding2
import com.news.newsappmvvm.presentation.onboardingscreen.component.common.NewsButton
import com.news.newsappmvvm.presentation.onboardingscreen.component.common.NewsTextButton
import com.news.newsappmvvm.presentation.onboardingscreen.component.common.PageIndicator
import com.news.newsappmvvm.presentation.onboardingscreen.pages
import kotlinx.coroutines.launch

private const val TAG = "OnBoardingScreen"
@Composable
fun OnBoardingScreen() {

    Column(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when(pagerState.currentPage){
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("")
                }
            }
        }

        HorizontalPager(pagerState) { index ->
            OnBoardPage(page = pages[index])
        }

        Spacer(modifier = Modifier.weight(1f))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = MediumPadding2)
            .navigationBarsPadding(), horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {

            PageIndicator(modifier = Modifier.width(50.dp),pageSize = pages.size, selectedPage = pagerState.currentPage)

            Row(verticalAlignment = Alignment.CenterVertically) {
                val scope = rememberCoroutineScope()
                if(buttonState.value[0].isNotBlank()){
                    NewsTextButton(title = buttonState.value[0], onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                        }
                    })
                }

                    NewsButton(
                        text = buttonState.value[1],
                        onclick = {
                            scope.launch {
                                if(pagerState.currentPage == 2){
                                    //todo navigated to homescreen
                                    Log.d(TAG, "OnBoardingScreen: finish page")
                                }else {
                                    pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                                }
                            }
                        }
                    )
            }
        }
    }
}