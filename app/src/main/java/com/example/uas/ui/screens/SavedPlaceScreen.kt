// com.example.uas.ui.screens.SavedPlacesScreen.kt
package com.example.uas.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.uas.R
import com.example.uas.ui.theme.UASTheme
import com.example.uas.ui.components.SavedPlaceCard
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

data class Place(
    val name: String,
    val description: String,
    val city: String,
    val imageResId: Int
)

val dummyPlaces = listOf(
    Place("Teluk Cendrawasih", "Pantai dengan pasir putih...", "Papua Barat", R.drawable.teluk_cendrawasih),
    Place("Gunung Bromo", "Tempat favorit para pendaki...", "Jawa Timur", R.drawable.bromo),
    Place("Gunung Rinjani", "Tempat favorit para pendaki...", "NTB", R.drawable.rinjani)
)

@Composable
fun SavedPlacesScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDAF8FF)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(top = 32.dp, bottom = 32.dp),
            verticalAlignment = Alignment.CenterVertically){
            Icon(
                painter = painterResource(id = R.drawable.angle_left),
                contentDescription = "Back",
                tint = Color(0xFF086788),
                modifier = Modifier
                    .size(20.dp)
                    .clickable {
                        navController.popBackStack() // 👈 Navigasi balik ke screen sebelumnya
                    }
            )
            Spacer(modifier = Modifier.width(80.dp))
            Text(
                text = "Saved Places",
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFF086788)
            )
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            items(dummyPlaces) { place ->
                SavedPlaceCard(
                    place = place,
                    onClick = {
                        when (place.name) {
                            "Teluk Cendrawasih" -> navController.navigate("telukcendrawasih_screen")
                            "Gunung Bromo" -> navController.navigate("bromo_screen")
                            "Gunung Rinjani" -> navController.navigate("rinjani_screen")
                            // Tambahkan lainnya jika kamu ingin detail screen terpisah
                            else -> { /* default / fallback */ }
                        }
                    }
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