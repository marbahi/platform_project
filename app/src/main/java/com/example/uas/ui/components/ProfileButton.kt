package com.example.uas.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.uas.R
import com.example.uas.ui.screens.ProfileScreen
import com.example.uas.ui.theme.UASTheme

@Composable
fun ProfileButton(icon: Int, label: String, onClick: () -> Unit, color: Color = Color(0xFF086788)) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(63.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFDAF8FF))
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            painter = painterResource(id = icon),
            contentDescription = label,
            tint = color,
            modifier = Modifier
                    .size(25.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = label,
            color = color,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth(0.9f)
        )
        Icon(
            painter = painterResource(id = R.drawable.angle_left),
            contentDescription = "Next",
            tint = color,
            modifier = Modifier
                .size(20.dp)
                .graphicsLayer {
                    rotationZ = 180f
                }
        )
    }
    Spacer(modifier = Modifier.height(3.dp))
}

@Composable
fun DividerLine() {
    Divider(
        modifier = Modifier
            .fillMaxWidth(0.85f)
            .height(1.dp),
        color = Color(0xFF86C5E8)
    )
    Spacer(modifier = Modifier.height(3.dp))
}

@Composable
fun ProfileScreenPreviewOnly() {
    // Dummy NavController agar tidak error, hanya untuk preview
    val dummyNavController = rememberNavController()
    ProfileScreen(navController = dummyNavController)
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    UASTheme {
        ProfileScreenPreviewOnly()
    }
}