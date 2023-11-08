package com.example.newsapp.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsapp.domain.usacase.articles.SearchArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchArticlesVewModel @Inject constructor(
    private val useCase: SearchArticlesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(SearchState())
    val state:State<SearchState> = _state

    fun onSearchEvent(event: SearchEvent){
        when(event){
            is SearchEvent.SearchNews -> {
                searchNews()
            }
            is SearchEvent.UpdateSearchQuery -> {
                _state.value = _state.value.copy(searchQuery =event.searchQuery)
            }

            else -> {}
        }
    }


    private fun searchNews() {
        val articles = useCase.searchArticles.invoke(
            searchQuery = _state.value.searchQuery ,
            sources = listOf("bbc-news" , "abc-news" , "al-jazeera-english")
        ).cachedIn(viewModelScope)

        _state.value = state.value.copy(listOfArticles = articles)
    }

}