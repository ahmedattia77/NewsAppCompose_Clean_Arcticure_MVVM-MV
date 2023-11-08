package com.example.newsapp.presentation.search

import androidx.paging.PagingData
import com.example.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
     val searchQuery: String = "" ,
     val listOfArticles: Flow<PagingData<Article>>? = null
)
