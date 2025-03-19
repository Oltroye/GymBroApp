package com.example.appessai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.appessai.database.AppDatabase
import com.example.appessai.repository.UserRepository
import com.example.appessai.viewmodel.UserViewModel
import com.example.appessai.theme.AppEssaiTheme
import com.example.appessai.navigation.NavigationGraph

class MainActivity : ComponentActivity() {
    private val database by lazy { AppDatabase.getDatabase(this) }
    private val userRepository by lazy { UserRepository(database.userDao()) }

    private val userViewModel by lazy {
        ViewModelProvider(this, UserViewModel.Factory(userRepository))[UserViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppEssaiTheme {
                val navController = rememberNavController()
                NavigationGraph(navController, userViewModel)
            }
        }
    }
}
