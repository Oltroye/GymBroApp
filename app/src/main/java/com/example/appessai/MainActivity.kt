package com.example.appessai

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
