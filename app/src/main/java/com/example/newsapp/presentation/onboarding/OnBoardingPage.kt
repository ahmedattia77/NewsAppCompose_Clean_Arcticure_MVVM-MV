package com.example.newsapp.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.newsapp.R
import com.example.newsapp.presentation.Dimens

@Composable
fun OnBoardingPage(
    page: Page,
    modifier : Modifier
) {

    Column(
        modifier = modifier
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight(fraction = 0.6f)
                .fillMaxWidth(),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(Dimens.MedVerticalPadding))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = Dimens.MedHorizontalPadding),
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.display_small) ,
            fontSize = 26.sp
        )
        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = Dimens.MedHorizontalPadding),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.text_medium),
            fontSize = 12.sp
        )
    }

}