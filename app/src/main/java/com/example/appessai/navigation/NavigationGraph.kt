package com.example.appessai.navigation

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appessai.ui.UserScreen
import com.example.appessai.ui.UserFormScreen
import com.example.appessai.viewmodel.UserViewModel

@Composable
fun NavigationGraph(navController: NavHostController, userViewModel: UserViewModel) {
    val user by userViewModel.user.collectAsState(initial = null)

    NavHost(navController = navController, startDestination = if (user == null) "user_form" else "user_screen") {
        composable("user_form") {
            UserFormScreen(userViewModel) {
                navController.navigate("user_screen")
            }
        }
        composable("user_screen") {
            UserScreen(userViewModel)
        }
    }
}
