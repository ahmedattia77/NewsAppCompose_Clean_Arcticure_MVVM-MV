package com.example.newsapp.domain.usacase.articles

import androidx.paging.PagingData
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.SearchArticlesRepository
import kotlinx.coroutines.flow.Flow

class SearchArticles(
    private val repository: SearchArticlesRepository
) {

     operator fun invoke(sources: List<String>, searchQuery: String):
             Flow<PagingData<Article>> = repository.searchArticles(
             sources = sources,
             searchQuery = searchQuery
         )

}
