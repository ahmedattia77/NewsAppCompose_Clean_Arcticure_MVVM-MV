package com.example.newsapp.presentation.bookmark

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.usacase.articles.room_usecase.RoomArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BookMarkViewModel @Inject constructor(
    private val useCase: RoomArticlesUseCase
): ViewModel(){

    private val _sate = mutableStateOf(BookmarkState())
    val sate: State<BookmarkState> = _sate

    init {
        getArticles()
    }

    private fun getArticles(){
        useCase.selectArticle().onEach {
            _sate.value = _sate.value.copy(article = it)
        }.launchIn(viewModelScope)
    }

}