package com.news.newsappmvvm.presentation.onboardingscreen.presentation.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.news.newsappmvvm.R
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.model.Article
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.common.ArticlesList
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.common.SearchBar
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.navigation.Route

private const val TAG = "HomeScreen"
@Composable
fun HomeScreen(articles : LazyPagingItems<Article>, navigate: (String) -> Unit) {
    val title by remember {
        derivedStateOf {
            if(articles.itemCount > 10){
                articles.itemSnapshotList.items.slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83d\uDFE5 ") {it.title.toString()}
            }else {
                ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp)
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(R.drawable.app_logo),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(50.dp)
        )
        Spacer(
            modifier = Modifier.height(20.dp)
        )

        SearchBar(
            text = "",
            onValueChange = {

            },
            readOnly = true,
            onSearch = {
                navigate(Route.SearchScreen.route)
            },
            onclick = {
                Log.d(TAG, "HomeScreen: ")
            }
        )
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
                .basicMarquee(),
            color = Color.Gray
        )
        Spacer(
            modifier = Modifier.height(10.dp)
        )

        ArticlesList(
            modifier = Modifier.padding(horizontal = 10.dp),
            articles = articles, onClick = {

        })
    }
}

