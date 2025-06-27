package com.example.uas.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uas.ui.screens.Place
import com.example.uas.ui.screens.SavedPlacesScreen
import com.example.uas.ui.theme.UASTheme
import com.example.uas.ui.theme.VerySmallTextStyle
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.clickable
import androidx.navigation.compose.rememberNavController

@Composable
fun SavedPlaceCard(
    place: Place,
    onClick: (() -> Unit)? = null // ← Parameter opsional
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(169.dp)
            .clip(RoundedCornerShape(20.dp))
            .then(
                if (onClick != null) Modifier.clickable { onClick() } else Modifier
            )
    ) {
        Image(
            painter = painterResource(id = place.imageResId),
            contentDescription = place.name,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Color.Transparent, Color(0xAA086788))
                    )
                )
                .padding(12.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize().padding(top = 90.dp)) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = place.name,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .weight(1f)
                            .alignByBaseline()
                    )
                    Text(
                        text = place.city,
                        color = Color.White,
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.alignByBaseline()
                    )
                }

                Text(
                    text = place.description,
                    style = VerySmallTextStyle,
                    color = Color.White,
                    maxLines = 2
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSavedPlace() {
    val dummyNavController = rememberNavController()
    UASTheme {
        SavedPlacesScreen(navController = dummyNavController)
    }
}