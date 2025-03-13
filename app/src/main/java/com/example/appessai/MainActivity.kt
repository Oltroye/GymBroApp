package com.example.appessai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*

import com.example.appessai.ui.theme.AppEssaiTheme
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppEssaiTheme {
                // Passer le navController ici pour la navigation
                val navController = rememberNavController()
                NavigationGraph(navController = navController)
            }
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    // Définir les routes pour la navigation
    NavHost(navController = navController, startDestination = "trainingList") {
        composable("trainingList") {
            TrainingListScreen(navController)
        }
        composable("details/{trainingType}") { backStackEntry ->
            val trainingType = backStackEntry.arguments?.getString("trainingType")
            TrainingDetailScreen(trainingType = trainingType ?: "Inconnu")
        }
    }
}

@Composable
fun TrainingListScreen(navController: NavHostController) {
    val trainings = listOf(
        "Force",
        "Hypertophie",
        "Cardio",
        "Personnaliser"
    )

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(trainings) { training ->
            TrainingItem(training = training, navController = navController)
        }
    }
}

@Composable
fun TrainingItem(training: String, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,  // Centrage horizontal
        verticalArrangement = Arrangement.Center // Centrage vertical si nécessaire
    ) {
        Text(text = training, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                // Lors de la validation, la navigation se fait vers le programme détaillé
                navController.navigate("details/$training")
            }
        ) {
            Text("Valider")
        }
    }
}


@Composable
fun TrainingDetailScreen(trainingType: String) {
    // Ici, tu peux afficher le programme détaillé pour le type d'entraînement sélectionné
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->  // Utilise innerPadding ici
        Column(modifier = Modifier
            .padding(16.dp)
            .padding(innerPadding)) {  // Applique innerPadding au contenu
            Text(text = "Programme détaillé pour : $trainingType", fontSize = 24.sp)
            // Ajoute ici les détails de l'entraînement, par exemple une liste d'exercices
            // Tu peux personnaliser ce contenu selon le type d'entraînement
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppEssaiTheme {
        TrainingListScreen(navController = rememberNavController())
    }
}
