package com.news.newsappmvvm.presentation.onboardingscreen.presentation.details.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.news.newsappmvvm.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopBar(
    onBrowsingClick: () -> Unit,
    onShareClick: () -> Unit,
    onBookMarkClick: () -> Unit,
    onBackPress: () -> Unit
) {
    TopAppBar(
        title = {},
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent,
            actionIconContentColor = colorResource(id = R.color.black),
            navigationIconContentColor = colorResource(id = R.color.black)
        ),
        navigationIcon = {
            IconButton(onClick = onBackPress) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton(onClick = onBookMarkClick) {
                Icon(painter = painterResource(id = R.drawable.bookmark_svgrepo_com), contentDescription = null)
            }
            IconButton(onClick = onShareClick) {
                Icon(painter = painterResource(R.drawable.share_svgrepo_com), contentDescription = null)
            }
            IconButton(onClick = onBrowsingClick) {
                Icon(painter = painterResource(R.drawable.network_backup_svgrepo_com), contentDescription = null)
            }
        }
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Preview() {
    DetailsTopBar(
        onBrowsingClick = {},
        onShareClick = {},
        onBookMarkClick = {},
        onBackPress = {}
    )
}