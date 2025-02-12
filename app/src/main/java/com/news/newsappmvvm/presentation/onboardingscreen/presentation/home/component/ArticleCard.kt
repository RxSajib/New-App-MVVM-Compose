package com.news.newsappmvvm.presentation.onboardingscreen.presentation.home.component

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.news.newsappmvvm.R
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.model.Article
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.model.Source
import com.news.newsappmvvm.ui.theme.NewsAppMVVMTheme

@Composable
fun ArticleCard(article: Article, modifier: Modifier = Modifier, clickable: () -> Unit) {

    val context = LocalContext.current

    Row(modifier = modifier.clickable { clickable() }) {
        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .aspectRatio(1f)
                .clip(shape = RoundedCornerShape(size = 10.dp)),
            model = ImageRequest.Builder(context = context).data(article.urlToImage).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.error),
            error = painterResource(R.drawable.error)
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .height(100.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = article.description ?: "",
                style = TextStyle(fontWeight = FontWeight.Medium),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = article.author ?: "",
                    style = TextStyle(fontSize = 12.sp, color = Color.Gray)
                )
                Spacer(modifier = Modifier.width(5.dp))

                Icon(imageVector = Icons.Default.DateRange, contentDescription = null, Modifier.size(12.dp), tint = Color.Gray)

                Text(
                    text = article.publishedAt ?: "",
                    style = TextStyle(fontSize = 12.sp, color = Color.Gray)
                )
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = article.title ?: "",
                style = TextStyle(fontWeight = FontWeight.Medium),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.width(10.dp))

            Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null)
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = article.publishedAt ?: "",
                style = TextStyle(fontWeight = FontWeight.Medium),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Preview() {
    NewsAppMVVMTheme {
        ArticleCard(
            article = Article(
                author = "Sajib Roy",
                content = "",
                publishedAt = "12 JUN 2025",
                source = Source(id = "", name = ""),
                title = "US",
                description = "This is a new title for testing kotlin compose app",
                url = "https://static.vecteezy.com/system/resources/previews/026/408/485/non_2x/man-lifestyle-portrait-hipster-serious-t-shirt-isolated-person-white-background-american-smile-confident-fashion-photo.jpg",
                urlToImage = "https://static.vecteezy.com/system/resources/previews/026/408/485/non_2x/man-lifestyle-portrait-hipster-serious-t-shirt-isolated-person-white-background-american-smile-confident-fashion-photo.jpg"
            ),
            modifier = Modifier,
            clickable = {}
        )
    }

}