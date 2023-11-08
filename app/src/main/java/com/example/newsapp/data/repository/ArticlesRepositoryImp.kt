package com.example.newsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.newsapp.data.remote.ApiService
import com.example.newsapp.data.remote.ArticlesPagingSource
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.ArticlesRepository
import kotlinx.coroutines.flow.Flow

class ArticlesRepositoryImp(
    private val apiService: ApiService ,
): ArticlesRepository  {

    override  fun getArticles(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
                config = PagingConfig(10),
                pagingSourceFactory = {
                    ArticlesPagingSource(
                        apiService = apiService,
                        sources = sources.joinToString(separator = ",")
                    )
                }
            ).flow
    }

}