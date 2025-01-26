package com.news.newsappmvvm.presentation.onboardingscreen.component

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.news.newsappmvvm.Dimens.MediumPadding
import com.news.newsappmvvm.Dimens.MediumPadding2
import com.news.newsappmvvm.R
import com.news.newsappmvvm.presentation.onboardingscreen.Page

@Composable
fun OnBoardPage(modifier: Modifier = Modifier, page: Page) {

    Column {
        Column(modifier = modifier) {
            Image(
                painter = painterResource(page.image),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.6f),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(MediumPadding))
            Text(
                text = page.title,
                modifier = Modifier.padding(horizontal = MediumPadding2).align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(MediumPadding2))
            Text(
                text = page.details,
                modifier = Modifier.fillMaxWidth(.95f).align(Alignment.CenterHorizontally),
                style = TextStyle(color = Color.Gray)
            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true,)
@Preview( uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun Preview() {
    OnBoardPage(
        page = Page(
            title = "News for today",
            details = "On top of the servers being full or just going offline completely, it appears that there’s an issue with the game’s Dynasty Mode as well",
            image = R.drawable.logo
        )
    )
}