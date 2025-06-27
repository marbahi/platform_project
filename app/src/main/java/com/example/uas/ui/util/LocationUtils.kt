package com.example.uas.ui.util

import android.annotation.SuppressLint
import android.content.Context
import android.location.Geocoder
import android.location.Location
import androidx.compose.runtime.*
import com.google.android.gms.location.*
import java.util.*

@SuppressLint("MissingPermission")
@Composable
fun getCurrentLocation(
    context: Context,
    fusedLocationProviderClient: FusedLocationProviderClient,
    onLocationReceived: (shortName: String, fullName: String) -> Unit
) {
    LaunchedEffect(Unit) {
        fusedLocationProviderClient.lastLocation.addOnSuccessListener { location: Location? ->
            location?.let {
                val geocoder = Geocoder(context, Locale.getDefault())
                val addresses = geocoder.getFromLocation(it.latitude, it.longitude, 1)
                val fullLocationName = addresses?.firstOrNull()?.subAdminArea ?: "Unknown"
                val shortName = fullLocationName
                    .split(" ")
                    .joinToString("") { word -> word.firstOrNull()?.uppercase() ?: "" }

                onLocationReceived(shortName, fullLocationName)
            }
        }
    }
}