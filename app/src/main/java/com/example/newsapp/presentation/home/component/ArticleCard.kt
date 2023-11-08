package com.example.newsapp.presentation.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newsapp.R
import com.example.newsapp.domain.model.Article
import com.example.newsapp.presentation.Dimens.ArticleCardSize
import com.example.newsapp.presentation.Dimens.SmallIconSize
import com.example.newsapp.presentation.Dimens.SmallPadding
import com.example.newsapp.presentation.Dimens.SmallPadding2

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit
) {
    val context = LocalContext.current

    Row(modifier = Modifier.clickable { onClick() }) {
        AsyncImage(
            modifier = Modifier
                .size(ArticleCardSize)
                .clip(shape = MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = SmallPadding)
                .height(ArticleCardSize),
        ) {
            Text(text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id =  R.color.text_title) ,
                maxLines = 2 ,
                overflow = TextOverflow.Ellipsis)

            Text(
                text = article.source.name,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.body)
            )

            Row (verticalAlignment = Alignment.CenterVertically){
            Icon(
                painter = painterResource(id = R.drawable.time),
                contentDescription = null,
                modifier = Modifier.size(SmallIconSize),
                tint = colorResource(id = R.color.body)
            )
            Spacer(modifier = Modifier.width(SmallPadding))

            Text(text = article.publishedAt,
                style = MaterialTheme.typography.labelSmall,
                color = colorResource(id =  R.color.body))
            }
        }
    }

}