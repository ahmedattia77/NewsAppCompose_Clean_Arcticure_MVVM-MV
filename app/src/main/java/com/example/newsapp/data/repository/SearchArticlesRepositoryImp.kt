package com.example.newsapp.data.repository

import androidx.paging.PagingData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.newsapp.data.remote.ApiService
import com.example.newsapp.data.remote.ArticlesPagingSource
import com.example.newsapp.data.remote.SearchArticlesPagingSource
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.SearchArticlesRepository
import kotlinx.coroutines.flow.Flow

class SearchArticlesRepositoryImp(
    private val apiService: ApiService

) : SearchArticlesRepository {

    override fun searchArticles(
        sources: List<String>,
        searchQuery: String
    ): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(10),
            pagingSourceFactory = {
                SearchArticlesPagingSource(
                    apiService = apiService,
                    sources = sources.joinToString(separator = ",") ,
                    q = searchQuery
                )
            }
        ).flow
    }
}