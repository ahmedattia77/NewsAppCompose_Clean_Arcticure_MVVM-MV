package com.example.newsapp.presentation.navGraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.newsapp.domain.usacase.articles.SearchArticles
import com.example.newsapp.presentation.bookmark.BookMarkViewModel
import com.example.newsapp.presentation.bookmark.BookmarkScreen
import com.example.newsapp.presentation.home.HomeScreen
import com.example.newsapp.presentation.home.HomeViewModel
import com.example.newsapp.presentation.onboarding.OnBoardingScreen
import com.example.newsapp.presentation.onboarding.OnBoardingViewModel
import com.example.newsapp.presentation.search.SearchArticlesVewModel
import com.example.newsapp.presentation.search.SearchScreen

@Composable
fun NavGraph(
    startDestination: String
){

    val navController  = rememberNavController()

    NavHost(navController = navController , startDestination = startDestination ){
        navigation(
            route = Rout.AppStartNavigation.rout,
            startDestination = Rout.OnBoardScreen.rout
        ){
            composable(route = Rout.OnBoardScreen.rout){
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(event = viewModel::onEvent)
            }
        }

        navigation(
            route = Rout.NewsNavigation.rout ,
            startDestination = Rout.NewsNavigationScreen.rout
        ){
            composable(route = Rout.NewsNavigationScreen.rout){
                val viewmodel: BookMarkViewModel = hiltViewModel()
                BookmarkScreen(state = viewmodel.sate.value, navigate ={} )
            }
        }

    }
}