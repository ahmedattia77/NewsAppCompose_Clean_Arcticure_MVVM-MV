package com.example.newsapp

import androidx.lifecycle.ViewModel
import com.example.newsapp.domain.usacase.app_entry.AppEntryUseCases
import kotlinx.coroutines.flow.onEach
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.newsapp.presentation.navGraph.Rout
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
) : ViewModel() {

    var appEntryCheck by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Rout.AppStartNavigation.rout)
        private set

    init {
        appEntryUseCases.readUserEntry().onEach {
            if (it)
                startDestination = Rout.NewsNavigation.rout
            else
                startDestination = Rout.AppStartNavigation.rout

            delay(300)
            appEntryCheck = false

        }.launchIn(viewModelScope)
    }
}