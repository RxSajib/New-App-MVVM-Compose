package com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.news

data class NewsUseCase(
     val getNews: GetNews,
     val searchNews: SearchNews,
     val upsertArticles: UpsertArticles,
     val deleteArticles: DeleteArticles,
     val getArticles: GetArticles
)
