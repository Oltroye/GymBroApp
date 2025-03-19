package com.example.appessai.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appessai.viewmodel.UserViewModel

@Composable
fun UserScreen(userViewModel: UserViewModel) {
    val user by userViewModel.user.collectAsState(initial = null)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        user?.let {
            Text("Nom : ${it.firstName} ${it.lastName}", fontSize = 24.sp)
            Text("Âge : ${it.age} ans")
            Text("Poids : ${it.weight} kg")
            Text("Taille : ${it.height} cm")

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                userViewModel.insertOrUpdate(it.copy(weight = it.weight + 1))
            }) {
                Text("Augmenter le poids de 1kg")
            }
        } ?: Text("Chargement des données...")
    }
}
