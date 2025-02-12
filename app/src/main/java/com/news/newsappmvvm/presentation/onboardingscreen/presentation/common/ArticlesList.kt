package com.news.newsappmvvm.presentation.onboardingscreen.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.model.Article
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.component.Empty
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.component.ShimmerEffect
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.home.component.ArticleCard

@Composable
fun ArticlesList(
    modifier: Modifier = Modifier,
    articles: LazyPagingItems<Article>,
    onClick: (Article) -> Unit
) {
    val result = handingPagingResult(articles = articles)
    if(result){
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(count = articles.itemCount){
                articles[it]?.let {
                    ArticleCard(article = it, clickable = {
                        onClick(it)
                    })
                }
            }
        }
    }
}

@Composable
fun handingPagingResult(
    articles: LazyPagingItems<Article>
) : Boolean {
    val loadState = articles.loadState
    val error = when{
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        else -> null
    }

    return when{
        loadState.refresh is LoadState.Loading -> {
            //todo shimmer effect
            ShimmerEffect()
            false
        }
        error != null ->{
            Empty()
            false
        }
        else -> {
            true
        }
    }
}

