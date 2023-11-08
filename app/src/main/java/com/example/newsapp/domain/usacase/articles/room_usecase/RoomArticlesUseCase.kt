package com.example.newsapp.domain.usacase.articles.room_usecase

import com.example.newsapp.domain.usacase.articles.DeleteArticle
import com.example.newsapp.domain.usacase.articles.SelectArticle
import com.example.newsapp.domain.usacase.articles.UpsertArticle

data class RoomArticlesUseCase(
     val upsertArticles: UpsertArticle ,
     val selectArticle: SelectArticle ,
     val deleteArticle: DeleteArticle
)
