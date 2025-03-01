

package com.news.newsappmvvm.presentation.onboardingscreen.presentation.news_navigation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.news.newsappmvvm.R

@Composable
fun NewsBottomNavigation(
    items: List<BottomNavigationItem>,
    selected: Int,
    onItemClick: (Int) -> Unit
) {
    NavigationBar (
        modifier = Modifier.fillMaxWidth()
    ){
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == selected,
                onClick = {onItemClick(index)},
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = item.text,
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                },
                colors = NavigationBarItemColors(
                    selectedIconColor = Color.Blue.copy(0.5f),
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = Color.Blue.copy(0.5f),
                    unselectedTextColor = Color.Gray,
                    selectedIndicatorColor = Color.Gray.copy(0.3f),
                    disabledIconColor = Color.Gray,
                    disabledTextColor = Color.Gray,
                )

            )
        }
    }
}

data class BottomNavigationItem(
    @DrawableRes val icon: Int,
    val text: String
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    NewsBottomNavigation(
        items = listOf(
            BottomNavigationItem(
                icon =  R.drawable.home_svgrepo_com,
                text = "Home"
            ),
            BottomNavigationItem(
                icon =  R.drawable.search_alt_svgrepo_com,
                text = "Search"
            ), BottomNavigationItem(
                icon =  R.drawable.bookmark_svgrepo_com,
                text = "BookMark"
            )
        ),
        selected = 2,
        onItemClick = {}
    )
}