package com.example.uas

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.uas.ui.navigation.AppNavigation
import com.example.uas.ui.components.BottomNavBar
import com.example.uas.ui.theme.UASTheme
import com.example.uas.ui.util.getCurrentLocation
import android.content.IntentSender
import android.widget.Toast
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import androidx.core.view.WindowCompat // ← TAMBAHKAN INI

class MainActivity : ComponentActivity() {

    private lateinit var locationRequest: LocationRequest
    private lateinit var locationSettingsClient: SettingsClient

    override fun onCreate(savedInstanceState: Bundle?) {
        // ⬇️ Tambahkan baris ini sebelum super.onCreate()
        WindowCompat.setDecorFitsSystemWindows(window, false)

        super.onCreate(savedInstanceState)

        locationRequest = LocationRequest.create()
            .setPriority(Priority.PRIORITY_HIGH_ACCURACY)
        locationSettingsClient = LocationServices.getSettingsClient(this)

        // Launch permission request
        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            val granted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true
            if (granted) {
                checkGPSAndLaunch()
            } else {
                Toast.makeText(this, "Izin lokasi ditolak", Toast.LENGTH_SHORT).show()
                showMainContent("") // tetap buka app tanpa lokasi
            }
        }

        permissionLauncher.launch(
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)
        )
    }

    private fun checkGPSAndLaunch() {
        val request = LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequest)
            .build()

        locationSettingsClient.checkLocationSettings(request)
            .addOnSuccessListener {
                showMainContentWithLocation()
            }
            .addOnFailureListener { exception ->
                if (exception is ResolvableApiException) {
                    try {
                        exception.startResolutionForResult(this, 1001)
                    } catch (sendEx: IntentSender.SendIntentException) {
                        showMainContent("") // fallback
                    }
                } else {
                    showMainContent("") // fallback
                }
            }
    }

    private fun showMainContentWithLocation() {
        setContent {
            var locationShort by remember { mutableStateOf("LOC") }
            var locationFull by remember { mutableStateOf("Loading...") }

            val fusedLocationProviderClient = remember {
                LocationServices.getFusedLocationProviderClient(this)
            }

            getCurrentLocation(
                context = this,
                fusedLocationProviderClient = fusedLocationProviderClient
            ) { short, full ->
                locationShort = short
                locationFull = full
            }

            UASTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                Scaffold(
                    bottomBar = {
                        BottomNavBar(navController = navController, currentRoute = currentRoute)
                    }
                ) { innerPadding ->
                    AppNavigation(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding),
                        // ⛔ Tambahkan ini jika kamu ingin kirim lokasi
                        // locationShort = locationShort,
                        // locationFull = locationFull
                    )
                }
            }
        }
    }

    private fun showMainContent(location: String) {
        setContent {
            UASTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                Scaffold(
                    bottomBar = {
                        BottomNavBar(navController = navController, currentRoute = currentRoute)
                    }
                ) { innerPadding ->
                    AppNavigation(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}