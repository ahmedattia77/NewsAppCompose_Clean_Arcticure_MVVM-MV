package com.example.newsapp.presentation.bookmark

import com.example.newsapp.domain.model.Article

data class BookmarkState(
    val article:List<Article> = emptyList()
)
