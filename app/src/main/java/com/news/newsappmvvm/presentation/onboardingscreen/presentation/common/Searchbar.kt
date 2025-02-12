package com.news.newsappmvvm.presentation.onboardingscreen.presentation.common

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.news.newsappmvvm.R

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    text: String,
    readOnly: Boolean,
    onclick: (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
    onSearch: () -> Unit
) {
    val interactionsource = remember {
        MutableInteractionSource()
    }

    val isClick = interactionsource.collectIsPressedAsState().value
    LaunchedEffect(key1 = isClick) {
        onclick?.invoke()
    }

    Box(modifier = modifier) {
        TextField(

            modifier = Modifier
                .fillMaxWidth().padding(horizontal = 10.dp)
                .searchBarBorder(),
            value = text,
            onValueChange = onValueChange,
            readOnly = readOnly,
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.search_alt_svgrepo_com),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = Color.Gray
                )
            },
            placeholder = {
                Text("Search ...")
            },
            shape = CircleShape,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Gray.copy(0.2f),
                focusedContainerColor = Color.Gray.copy(0.2f),
                cursorColor = Color.Green,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch ={
                    onSearch()
                }
            ),
            interactionSource = interactionsource
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SearchBar(
        text = "This is search",
        readOnly = false,
        onclick = {},
        onSearch = {},
        onValueChange = {}
    )
}

fun Modifier.searchBarBorder() = composed {
    if (!isSystemInDarkTheme()) {
        border(
            width = 1.dp,
            color = Color.Black,
            shape = CircleShape
        )
    } else {
        this
    }
}


