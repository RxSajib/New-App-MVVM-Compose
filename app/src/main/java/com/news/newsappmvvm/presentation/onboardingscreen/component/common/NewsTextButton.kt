package com.news.newsappmvvm.presentation.onboardingscreen.component.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NewsTextButton(
    title : String,
    onClick: ()-> Unit
) {
        TextButton(onClick = onClick) {
            Text(
                text = title,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
                color = Color.Gray
            )
        }
}

@Preview
@Composable
private fun Preview() {
    NewsTextButton(
        title = "Preview",
        onClick = {}
    )
}