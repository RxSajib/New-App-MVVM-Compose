package com.news.newsappmvvm.presentation.onboardingscreen.presentation.details

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.Uri
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.ImageResult
import com.news.newsappmvvm.R
import com.news.newsappmvvm.presentation.onboardingscreen.component.domain.model.Article
import com.news.newsappmvvm.presentation.onboardingscreen.presentation.details.component.DetailsTopBar

@Composable
fun DetailsScreen(
    article: Article,
    event: (DetailsEvent) -> Unit,
    navigatedUp: (String) -> Unit
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().statusBarsPadding()
    ) {
        DetailsTopBar(
            onBrowsingClick = {
                Intent(Intent.ACTION_VIEW).also {
                    it.data = android.net.Uri.parse(article.url)
                    if(it.resolveActivity(context.packageManager) != null){
                        context.startActivity(it)
                    }
                }
            },
            onShareClick = {
                Intent(Intent.ACTION_SEND).also {
                    it.putExtra(Intent.EXTRA_TEXT, article.url)
                    it.type = "text/plain"
                    if(it.resolveActivity(context.packageManager) != null){
                        context.startActivity(it)
                    }
                }
            },
            onBackPress = {},
            onBookMarkClick = {}
        )


        LazyColumn(modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(10.dp),
        ) {
           item {
               AsyncImage(
                   model = ImageRequest.Builder(context = context).data(article.urlToImage).build(),
                   contentDescription = null,
                   modifier = Modifier.fillMaxWidth().height(200.dp).clip(shape = RoundedCornerShape(size = 10.dp)),
                   contentScale = ContentScale.Crop,
                   error = painterResource(R.drawable.no_image_found),
                   placeholder = painterResource(R.drawable.loading_image)

               )
               Spacer(modifier = Modifier.height(15.dp))
               Text(
                   text = article.title?: "Unknown title",
                   style = MaterialTheme.typography.displaySmall,
                   color = colorResource(id = R.color.black)
               )
               Spacer(modifier = Modifier.height(10.dp))
               Text(
                   text = article.description?: "Unknown details",
                   style = MaterialTheme.typography.titleSmall,
                   color = colorResource(id = R.color.color_gray)
               )
           }

        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Preview() {
    DetailsScreen(
        article = Article(
            author = "",
            content = "",
            description = "Bangladesh, to the east of India on the Bay of Bengal, is a South Asian country marked by lush greenery and many waterways. Its Padma (Ganges), Meghna and Jamuna rivers create fertile plains, and travel by boat is common. On the southern coast, the Sundarbans, an enormous mangrove forest shared with Eastern India, is home to the royal Bengal tiger",
            publishedAt = "",
            title = "A New World",
            url = "https://translate.google.com/?sl=en&tl=bn&op=translate",
            source = null,
            urlToImage = "https://images.pexels.com/photos/56866/garden-rose-red-pink-56866.jpeg?cs=srgb&dl=pexels-pixabay-56866.jpg&fm=jpg"
        ),
        event = {},
        navigatedUp = {}
    )
}