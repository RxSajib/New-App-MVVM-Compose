package com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.news

import com.news.newsappmvvm.presentation.onboardingscreen.component.data.local.ArticleDao
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.model.Article
import kotlinx.coroutines.flow.Flow

class GetArticles constructor(
    private val dao: ArticleDao
) {

    operator fun invoke() : Flow<List<Article>> = dao.getAllArticle()
}