package com.example.newsapp.domain.repository

import androidx.paging.PagingData
import com.example.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface SearchArticlesRepository {

    fun searchArticles(sources: List<String> , searchQuery: String) : Flow<PagingData<Article>>

}