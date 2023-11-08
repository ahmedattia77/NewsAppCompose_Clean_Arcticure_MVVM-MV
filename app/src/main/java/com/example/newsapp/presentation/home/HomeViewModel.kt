package com.example.newsapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsapp.domain.usacase.articles.ArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val articlesUseCase: ArticlesUseCase
) : ViewModel() {

    val articles = articlesUseCase.getArticles(
        sources = listOf<String>("bbc-news" , "abc-news" , "al-jazeera-english")
    ).cachedIn(viewModelScope)


}