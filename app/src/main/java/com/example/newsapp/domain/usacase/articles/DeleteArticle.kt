package com.example.newsapp.domain.usacase.articles

import com.example.newsapp.data.local.ArticleDao
import com.example.newsapp.domain.model.Article

class DeleteArticle(
    private val articleDao: ArticleDao
) {
    suspend operator fun invoke(article: Article){
        articleDao.delete(article = article)
    }
}