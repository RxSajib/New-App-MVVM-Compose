package com.news.newsappmvvm.presentation.onboardingscreen.component.domain.usercase.news

import com.news.newsappmvvm.presentation.onboardingscreen.component.data.local.ArticleDao
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.model.Article

class DeleteArticles constructor(
    private val dao: ArticleDao
) {

    suspend operator fun invoke(article: Article){
        dao.deleteArticle(article = article)
    }
}