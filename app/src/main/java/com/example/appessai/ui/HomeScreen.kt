package com.example.appessai.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.appessai.viewmodel.HomeViewModel
import androidx.compose.runtime.livedata.observeAsState  // ✅ Import correct

@Composable
fun HomeScreen(navController: NavHostController, homeViewModel: HomeViewModel = viewModel()) {
    val welcomeMessage by homeViewModel.welcomeMessage.observeAsState(initial = "Chargement...")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Ajout de padding pour éviter que le texte touche les bords
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth() // Pour s'assurer que la colonne prend toute la largeur
        ) {
            Text(
                text = welcomeMessage,
                fontSize = 24.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally) // Forcer le centrage du texte
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("cardio") }) {
                Text("Programme Cardio")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { navController.navigate("custom") }) {
                Text("Créer un Programme Perso")
            }
        }
    }
}


