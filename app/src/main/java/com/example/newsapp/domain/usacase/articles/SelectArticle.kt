package com.example.newsapp.domain.usacase.articles

import com.example.newsapp.data.local.ArticleDao
import com.example.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticle(
    private val articleDao: ArticleDao
) {
    operator fun invoke(): Flow<List<Article>> = articleDao.getArticles()
}