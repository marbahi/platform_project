package com.example.uas.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.uas.ui.screens.HomeScreen
import com.example.uas.ui.screens.MapScreen
import com.example.uas.ui.screens.ProfileScreen
import com.example.uas.ui.screens.SavedPlacesScreen
import com.example.uas.ui.screens.TamanBaluranScreen
import com.example.uas.ui.screens.TamanKarimunjawaScreen
import com.example.uas.ui.screens.TamanTelukCendrawasihScreen
import com.example.uas.ui.screens.GunungBromoScreen
import com.example.uas.ui.screens.GunungGedeScreen
import com.example.uas.ui.screens.GunungRinjaniScreen
import com.example.uas.ui.screens.GunungSumbingScreen
import com.example.uas.ui.screens.NusaDuaScreen
import com.example.uas.ui.screens.PinkBeachScreen
import com.example.uas.ui.screens.PulauPadarScreen
import com.example.uas.ui.screens.TakaMakassarScreen
import com.example.uas.ui.screens.TamanWayKambasScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Map : Screen("map")
    object Profile : Screen("profile")
    object SavedPlaces : Screen("saved_places")
    object TamanBaluran : Screen("baluran_screen")
    object WayKambas : Screen("waykambas_screen")
    object KarimunJawa : Screen("karimunjawa_screen")
    object TamanTelukCendrawasih : Screen("telukcendrawasih_screen")
    object GunungBromo : Screen("bromo_screen")
    object GunungRinjani : Screen("rinjani_screen")
    object GunungSumbing : Screen("sumbing_screen")
    object GunungGede : Screen("gede_screen")
    object PulauPadar : Screen("padar_screen")
    object PinkBeach : Screen("pinkbeach_screen")
    object TakaMakassar : Screen("taka_screen")
    object NusaDua : Screen("nusadua_screen")
}

@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier, // ← Tambahkan ini
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier // ← Gunakan modifier di sini
    ) {
        composable(Screen.Home.route) { HomeScreen(navController = navController) }
        composable(Screen.Map.route) { MapScreen() }
        composable(Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(Screen.SavedPlaces.route) { SavedPlacesScreen(navController = navController) }
        composable(Screen.TamanBaluran.route) { TamanBaluranScreen(onBackClick = { navController.popBackStack() }) }
        composable(Screen.WayKambas.route) { TamanWayKambasScreen(onBackClick = { navController.popBackStack() }) }
        composable(Screen.KarimunJawa.route) { TamanKarimunjawaScreen(onBackClick = { navController.popBackStack() }) }
        composable(Screen.TamanTelukCendrawasih.route) { TamanTelukCendrawasihScreen(onBackClick = { navController.popBackStack() }) }
        composable(Screen.GunungBromo.route) { GunungBromoScreen(onBackClick = { navController.popBackStack() }) }
        composable(Screen.GunungRinjani.route) { GunungRinjaniScreen(onBackClick = { navController.popBackStack() }) }
        composable(Screen.GunungSumbing.route) { GunungSumbingScreen(onBackClick = { navController.popBackStack() }) }
        composable(Screen.GunungGede.route) { GunungGedeScreen(onBackClick = { navController.popBackStack() }) }
        composable(Screen.PulauPadar.route) { PulauPadarScreen(onBackClick = { navController.popBackStack() }) }
        composable(Screen.PinkBeach.route) { PinkBeachScreen(onBackClick = { navController.popBackStack() }) }
        composable(Screen.TakaMakassar.route) { TakaMakassarScreen(onBackClick = { navController.popBackStack() }) }
        composable(Screen.NusaDua.route) { NusaDuaScreen(onBackClick = { navController.popBackStack() }) }
        // Tambahkan screen lain jika ada
    }
}