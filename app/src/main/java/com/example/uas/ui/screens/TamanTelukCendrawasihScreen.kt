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
fun TamanTelukCendrawasihScreen(onBackClick: () -> Unit) {
    val place = DetailPlace(
        name = "Taman Teluk Cendrawasih",
        description = "Taman Nasional Teluk Cenderawasih merupakan taman laut terbesar di Indonesia, membentang seluas lebih dari 1,4 juta hektare. Kawasan ini dikenal sebagai surga bahari \n" +
                "dengan ekosistem laut yang sangat kaya, mencakup terumbu karang, perairan dangkal, hutan mangrove, dan pulau-pulau kecil yang masih alami. \n\n" +
                "Daya tarik utama taman nasional ini adalah kehadiran hiu paus (whale shark) di perairan Kwatisore, yang bisa dilihat dari dekat saat snorkeling atau diving. \n\n" +
                "Selain itu, Teluk Cenderawasih juga menjadi rumah bagi berbagai spesies langka seperti penyu, lumba-lumba, dugong, hingga ikan-ikan hias berwarna-warni. \n" +
                "Pulau-pulau seperti Rumberpon, Mioswaar, dan Roon menawarkan spot menyelam kelas dunia, air panas alami, dan situs budaya seperti gereja tua dan gua purba. \n\n" +
                "Taman nasional ini sangat cocok bagi wisatawan pencinta alam dan petualangan, yang ingin merasakan keindahan bawah laut Indonesia dalam suasana yang masih alami dan jauh dari hiruk pikuk wisata massal.",
        city = "Sobei Indah, Duairi, Kabupaten Teluk Wondama, Papua Barat",
        imageResId = R.drawable.teluk_cendrawasih,
        price = "Tiket Masuk: \n Rp. 20.000 (Hari Biasa) \n Rp. 30.000 (Hari Libur) \n\nTiket Parkir: \n -"
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
fun PreviewPlaceDetailScreen() {
    UASTheme {
        TamanTelukCendrawasihScreen(onBackClick = {})
    }
}