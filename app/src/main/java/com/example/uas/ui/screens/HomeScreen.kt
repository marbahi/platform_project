package com.example.uas.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uas.R
import com.example.uas.ui.theme.UASTheme
import com.example.uas.ui.theme.VerySmallTextStyle
import com.example.uas.ui.util.getCurrentLocation
import com.google.android.gms.location.LocationServices
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("MissingPermission")
@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current
    val fusedLocationProviderClient = remember {
        LocationServices.getFusedLocationProviderClient(context)
    }

    var shortLoc by remember { mutableStateOf("LOC") }
    var fullLoc by remember { mutableStateOf("Loading...") }

    val currentTime = remember {
        SimpleDateFormat("dd MMM, HH:mm", Locale.getDefault()).format(Date())
    }

    // 🔧 Pastikan getCurrentLocation mengembalikan 2 parameter (short, full)
    getCurrentLocation(
        context = context,
        fusedLocationProviderClient = fusedLocationProviderClient
    ) { short: String, full: String ->
        shortLoc = short
        fullLoc = full
    }

    val populerImages = listOf(
        Triple(R.drawable.baluran, "Taman Nasional Baluran", "baluran_screen"),
        Triple(R.drawable.waykambas, "Taman Nasional Way Kambas", "waykambas_screen"),
        Triple(R.drawable.karimunjawa, "Taman Nasional Karimunjawa", "karimunjawa_screen"),
        Triple(R.drawable.teluk_cendrawasih, "Taman Teluk Cendrawasih", "telukcendrawasih_screen"),
        Triple(R.drawable.bromo, "Gunung Bromo", "bromo_screen"),
        Triple(R.drawable.rinjani, "Gunung Rinjani", "rinjani_screen"),
        Triple(R.drawable.sumbing, "Gunung Sumbing", "sumbing_screen"),
        Triple(R.drawable.pangrango, "Gunung Gede Pangrango", "gede_screen"),
        Triple(R.drawable.padar, "Pulau Padar", "padar_screen"),
        Triple(R.drawable.pink_beach, "Pink Beach Labuan Bajo", "pinkbeach_screen"),
        Triple(R.drawable.taka_makassar, "Taka Makassar", "taka_screen"),
        Triple(R.drawable.nusa_dua, "Pantai Nusa Dua", "nusadua_screen")
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .background(Color(0xFFDAF8FF))
    ) {
        item {
            // Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.background),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomStart)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color(0xAA000000))
                            )
                        )
                        .padding(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 16.dp)
                    ) {
                        Text(
                            "Where are you",
                            color = Color.White,
                            style = MaterialTheme.typography.labelSmall
                        )
                        Text(
                            "traveling to?",
                            color = Color.White,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = null, tint = Color(0xFF086788))
                },
                placeholder = { Text("finding your destination", style = VerySmallTextStyle, color = Color(0xFF086788)) },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Upcoming Trips", style = MaterialTheme.typography.titleLarge, color = Color(0xFF07A0C3), modifier = Modifier.alignByBaseline())
                Text("All >", style = MaterialTheme.typography.labelSmall, color = Color(0xFF07A0C3), modifier = Modifier.alignByBaseline())
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color(0xFFDAF8FF)),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF086788)
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.Start) {
                        Text(text = currentTime, style = MaterialTheme.typography.labelSmall, color = Color(0xFFDAF8FF))
                        Text(text = shortLoc, style = MaterialTheme.typography.bodyMedium, color = Color(0xFFDAF8FF))
                        Text(text = fullLoc, style = MaterialTheme.typography.labelSmall, color = Color(0xFFDAF8FF))
                    }
                    Image(
                        painter = painterResource(id = R.drawable.pesawat),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color(0xFFDAF8FF)),
                        modifier = Modifier.size(100.dp)
                    )
                    Column(horizontalAlignment = Alignment.End) {
                        Text("13.10", style = MaterialTheme.typography.labelSmall, color = Color(0xFFDAF8FF))
                        Text("Gn. Sibayak", style = MaterialTheme.typography.bodyMedium, color = Color(0xFFDAF8FF))
                        Text("Gunung Sibayak", style = MaterialTheme.typography.labelSmall, color = Color(0xFFDAF8FF))
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Populer",
                modifier = Modifier.padding(start = 16.dp),
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFF07A0C3)
            )
        }

        items(populerImages.chunked(4)) { rowImages ->
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 8.dp, bottom = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(rowImages) { (imageRes, title, route) ->
                    ImageCardWithOverlayText(
                        imageRes = imageRes,
                        title = title,
                        onClick = { navController.navigate(route) }
                    )
                }
            }
        }
    }
}

@Composable
fun ImageCardWithOverlayText(imageRes: Int, title: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(120.dp)
            .height(160.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color(0xAA000000))
                    )
                )
                .padding(8.dp)
        ) {
            Text(
                text = title,
                color = Color.White,
                style = VerySmallTextStyle,
                maxLines = 1
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    UASTheme {
        HomeScreen(navController)
    }
}