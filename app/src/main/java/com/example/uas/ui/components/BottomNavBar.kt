package com.example.uas.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.uas.R
import com.example.uas.ui.navigation.Screen
import com.example.uas.ui.theme.UASTheme
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavBar(navController: NavController, currentRoute: String?) {
    NavigationBar(
        containerColor = Color(0xFFDAF8FF),
        tonalElevation = 6.dp
    ) {
        // HOME
        NavigationBarItem(
            selected = currentRoute == Screen.Home.route,
            onClick = {
                if (currentRoute != Screen.Home.route) {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "Home",
                    tint = if (currentRoute == Screen.Home.route) Color(0xFF086788) else Color(0xFF07A0C3),
                    modifier = Modifier.size(38.dp)
                )
            },
            alwaysShowLabel = false,
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent
            )
        )

        // MAP
        NavigationBarItem(
            selected = currentRoute == Screen.Map.route,
            onClick = {
                if (currentRoute != Screen.Map.route) {
                    navController.navigate(Screen.Map.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_map),
                    contentDescription = "Map",
                    tint = if (currentRoute == Screen.Map.route) Color(0xFF086788) else Color(0xFF07A0C3),
                    modifier = Modifier.size(38.dp)
                )
            },
            alwaysShowLabel = false,
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent
            )
        )

        // PROFILE
        NavigationBarItem(
            selected = currentRoute == Screen.Profile.route,
            onClick = {
                if (currentRoute != Screen.Profile.route) {
                    navController.navigate(Screen.Profile.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = "Profile",
                    tint = if (currentRoute == Screen.Profile.route) Color(0xFF086788) else Color(0xFF07A0C3),
                    modifier = Modifier.size(38.dp)
                )
            },
            alwaysShowLabel = false,
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBottomNavBar() {
    val dummyNavController = rememberNavController()
    UASTheme {
        BottomNavBar(
            navController = dummyNavController,
            currentRoute = Screen.Home.route // Contoh posisi aktif
        )
    }
}