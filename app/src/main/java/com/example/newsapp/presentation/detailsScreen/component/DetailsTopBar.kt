package com.example.newsapp.presentation.detailsScreen.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.example.newsapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopBar(
    onBookMarkClick: () -> Unit,
    onShareClick: () -> Unit,
    onBrowsingClick: () -> Unit,
    onBackClick: () -> Unit,
) {
    TopAppBar(
        title = {},
        modifier = Modifier.fillMaxWidth() ,
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent,
            actionIconContentColor = colorResource(id = R.color.body),
            navigationIconContentColor = colorResource(id = R.color.body)
        ),
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(painter = painterResource(id = R.drawable.back) , contentDescription = null )
            }
        } ,
        actions = {
            IconButton(onClick = onBackClick) {
                Icon(painter = painterResource(id = R.drawable.favorite) , contentDescription = null )
            }

            IconButton(onClick = onBackClick) {
                Icon(imageVector = Icons.Default.Share , contentDescription = null )
            }

            IconButton(onClick = onBackClick) {
                Icon(painter = painterResource(id = R.drawable.explore) , contentDescription = null )
            }
        }
    )
}