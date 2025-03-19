package com.example.appessai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ForceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.xml.activity_force)
    }
    // Dans un bouton "Enregistrer la séance" :
    lifecycleScope.launch {
        val session = SessionEntity(
            type = "Force",
            date = System.currentTimeMillis(),
            details = "Squat 5x5 à 90kg, Soulevé de terre 5x5 à 110kg"
        )
        sessionDao.insertSession(session)
    }
}
