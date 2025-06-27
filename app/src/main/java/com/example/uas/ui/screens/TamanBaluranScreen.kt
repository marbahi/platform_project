package com.example.uas.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uas.R
import com.example.uas.ui.theme.UASTheme
import com.example.uas.ui.theme.VeryBigTextStyle
import com.example.uas.ui.theme.VerySmallTextStyle
import com.example.uas.model.DetailPlace

// ✅ Screen
@Composable
fun TamanBaluranScreen(onBackClick: () -> Unit) {
    val place = DetailPlace(
        name = "Taman Nasional Baluran",
        description = "Taman Nasional Baluran adalah permata tersembunyi di ujung timur Pulau Jawa yang dikenal dengan julukan \"Africa van Java\". Kawasan ini menyajikan lanskap padang savana yang luas, " +
                "hutan tropis, gunung, hingga pesisir pantai yang eksotis. \n\nDengan luas lebih dari 25.000 hektare, Baluran menjadi rumah bagi beragam satwa liar seperti banteng, rusa, merak, elang, lutung, " +
                "hingga macan tutul. Spot ikoniknya, Savana Bekol, menawarkan pemandangan dramatis yang menyerupai sabana Afrika, cocok untuk fotografi alam dan petualangan.",
        city = "Area Hutan/Kebun, Sumberwaru, Kec. Banyuputih, Kabupaten Situbondo, Jawa Timur",
        imageResId = R.drawable.baluran,
        price = "Tiket Masuk: \n Rp. 21.000 - 31.000 \n\nTiket Parkir: \n Rp. 5.000 - 10.000"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDAF8FF))
    ) {
        // ✅ App Bar tetap di atas
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(Color(0xFF07A0C3)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = place.name,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFFDAF8FF)
            )
            Icon(
                painter = painterResource(id = R.drawable.angle_left),
                contentDescription = "Back",
                tint = Color(0xFFDAF8FF),
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 16.dp)
                    .size(20.dp)
                    .clickable { onBackClick() }
            )
        }

        // ✅ Scrollable content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            Image(
                painter = painterResource(id = place.imageResId),
                contentDescription = place.name,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .clip(RoundedCornerShape(20.dp))
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = place.name,
                style = VeryBigTextStyle,
                color = Color(0xFF086788),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            // ✅ Lokasi sebagai Card
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = place.city,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color(0xFF07A0C3),
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // ✅ Deskripsi
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Deskripsi",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF086788)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = place.description,
                    style = VerySmallTextStyle,
                    color = Color.DarkGray
                )
            }

            // ✅ Biaya (menggunakan properti dari `place`)
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 12.dp, bottom = 16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Biaya",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(0xFF086788)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = place.price,
                        style = VerySmallTextStyle,
                        color = Color.DarkGray
                    )
                }
            }
        }
    }
}

// ✅ Preview
@Preview(showBackground = true)
@Composable
fun PreviewBaluranScreen() {
    UASTheme {
        TamanBaluranScreen(onBackClick = {})
    }
}