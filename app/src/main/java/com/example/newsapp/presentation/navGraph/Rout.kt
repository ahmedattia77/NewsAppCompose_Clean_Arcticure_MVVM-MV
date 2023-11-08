package com.example.newsapp.presentation.navGraph

sealed class Rout(
    val rout: String
){
    object OnBoardScreen : Rout(rout ="onBoardScreen")
    object BookmarkScreen : Rout(rout ="bookMarkScreen")
    object SearchScreen : Rout(rout ="searchScreen")
    object DetailsScreen : Rout(rout ="detailsScreen")
    object AppStartNavigation : Rout(rout ="appStartNavigation")
    object NewsNavigation : Rout(rout ="newsNavigation")
    object NewsNavigationScreen : Rout(rout ="newsNavigationScreen")
}