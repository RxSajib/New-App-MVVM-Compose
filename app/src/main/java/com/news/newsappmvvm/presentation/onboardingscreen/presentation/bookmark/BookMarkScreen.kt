package com.news.newsappmvvm.presentation.onboardingscreen.presentation.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.common.BookMarkArticleList

@Composable
fun BookMarkScreen(
    bookMarkState: BookMarkState,
    navigator: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().statusBarsPadding().navigationBarsPadding().padding(15.dp)) {
        Text(
            text = "BookMark",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(10.dp))
        BookMarkArticleList(bookMarkState.list, onClick = {})
    }
}