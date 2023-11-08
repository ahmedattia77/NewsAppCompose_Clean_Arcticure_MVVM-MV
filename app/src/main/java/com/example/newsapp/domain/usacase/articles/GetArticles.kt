package com.example.newsapp.domain.usacase.articles

import androidx.paging.PagingData
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.ArticlesRepository
import kotlinx.coroutines.flow.Flow

class GetArticles(
    private val repository: ArticlesRepository
) {

     operator fun invoke(sources: List<String>)
        : Flow<PagingData<Article>> =  repository.getArticles(sources = sources)

}
