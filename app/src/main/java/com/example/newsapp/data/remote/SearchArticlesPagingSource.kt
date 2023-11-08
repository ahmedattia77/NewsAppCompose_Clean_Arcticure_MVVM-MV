package com.example.newsapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.newsapp.domain.model.Article

class SearchArticlesPagingSource (
    private val apiService: ApiService ,
    private val q: String ,
    private val sources: String ,

) :PagingSource<Int , Article>() {

    private var totalPages: Int = 0

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            val response = apiService.searchArticles(searchQuery = q ,page = page, sources = sources)
            val articles = response.articles
            totalPages = articles.size

            articles.distinctBy { it.title }
            LoadResult.Page(
                data = articles,
                nextKey = if (totalPages == response.totalResults) null else page + 1,
                prevKey = null
            )

        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(throwable = e)
        }
    }
}