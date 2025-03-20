package com.example.appessai

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.navigation.NavigationGraph

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavigationGraph(navController)
        }
        setContentView(R.xml.activity_main)

        val btnHypertrophie = findViewById<Button>(R.id.btn_hypertrophie)
        val btnForce = findViewById<Button>(R.id.btn_force)
        val btnSuivi = findViewById<Button>(R.id.btn_suivi)

        btnHypertrophie.setOnClickListener {
            val intent = Intent(this, HypertrophieActivity::class.java)
            startActivity(intent)
        }

        btnForce.setOnClickListener {
            val intent = Intent(this, ForceActivity::class.java)
            startActivity(intent)
        }

        btnSuivi.setOnClickListener {
            val intent = Intent(this, SuiviActivity::class.java)
            startActivity(intent)
        }
    }
}
