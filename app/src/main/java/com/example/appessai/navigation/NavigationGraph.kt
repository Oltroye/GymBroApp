package com.example.fitnessapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appessai.ui.CardioScreen
import com.example.appessai.ui.CustomWorkoutScreen
import com.example.appessai.ui.HomeScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("cardio") { CardioScreen() }
        composable("custom") { CustomWorkoutScreen() }
    }
}
