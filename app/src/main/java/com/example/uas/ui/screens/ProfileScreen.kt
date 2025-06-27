package com.example.uas.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import com.example.uas.R
import com.example.uas.ui.components.ProfileButton
import com.example.uas.ui.components.DividerLine
import androidx.compose.ui.tooling.preview.Preview
import com.example.uas.ui.theme.UASTheme
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

@Composable
fun ProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDAF8FF))
            .verticalScroll(rememberScrollState()), // 👈 scroll ditambahkan di sini
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(173.dp)
                .background(Color(0xFF086788))
        ) {
            Box(
                modifier = Modifier
                    .size(169.dp)
                    .offset(y = 80.dp)
                    .align(Alignment.BottomCenter)
                    .zIndex(1f)
                    .clip(CircleShape)
                    .background(Color(0xFFDAF8FF))
                    .padding(5.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )
            }
        }

        Spacer(modifier = Modifier.height(100.dp))

        Text(
            text = "Nama Pengguna",
            color = Color(0xFF07A0C3),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "email@example.com",
            color = Color(0xFF07A0C3),
            style = MaterialTheme.typography.labelSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        ProfileButton(
            icon = R.drawable.bookmark,
            label = "Saved Places",
            onClick = { navController.navigate("saved_places") }
        )
        DividerLine()
        ProfileButton(icon = R.drawable.pencil, label = "Edit Profile", onClick = {})
        DividerLine()
        ProfileButton(icon = R.drawable.language, label = "Language", onClick = {})
        DividerLine()
        ProfileButton(icon = R.drawable.customer_service, label = "Support", onClick = {})
        DividerLine()
        ProfileButton(icon = R.drawable.setting, label = "Settings", onClick = {})
        DividerLine()
        ProfileButton(icon = R.drawable.logout, label = "Log Out", onClick = {}, color = Color(0xFF880808))

        Spacer(modifier = Modifier.height(20.dp)) // Tambahan padding bawah agar tidak terlalu mepet
    }
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