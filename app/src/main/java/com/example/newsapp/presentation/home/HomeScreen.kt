package com.example.newsapp.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.paging.compose.LazyPagingItems
import com.example.newsapp.domain.model.Article
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.newsapp.R
import com.example.newsapp.presentation.Dimens
import com.example.newsapp.presentation.Dimens.MedHorizontalPadding
import com.example.newsapp.presentation.Dimens.MedVerticalPadding
import com.example.newsapp.presentation.Dimens.NewsAppSize
import com.example.newsapp.presentation.common.ArticlesList
import com.example.newsapp.presentation.common.Searchbar
import com.example.newsapp.presentation.navGraph.Rout

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    articles: LazyPagingItems<Article>,
    navigation: (String) -> Unit,
) {

    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83D\uDFE5 ") { it.title }
            } else {
                ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = Dimens.MedVerticalPadding)
            .statusBarsPadding()
    )
    {

        Text(
            modifier = Modifier.fillMaxWidth().padding(start = MedVerticalPadding),
            textAlign = TextAlign.Start,
            text = "NewsApp" ,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            fontSize = NewsAppSize
        )

        Spacer(modifier = Modifier.height(MedVerticalPadding))

        Searchbar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MedVerticalPadding),
            text = "",
            readOnly = true,
            onValueChange = {},
            onClick = { navigation(Rout.SearchScreen.rout) },
            onSearch = {}
        )

        Spacer(modifier = Modifier.height(MedHorizontalPadding))

        Text(
            text = titles,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = MedVerticalPadding)
                .basicMarquee(),
            fontSize = 12.sp,
            color = colorResource(id = R.color.placeholder)
        )
        Spacer(modifier = Modifier.height(Dimens.MedHorizontalPadding))

        ArticlesList(
            modifier = Modifier.padding(horizontal = Dimens.MedVerticalPadding) ,
            articles = articles ,
            onClick = { navigation(Rout.DetailsScreen.rout) }
        )

    }


}