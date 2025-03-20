package com.example.appessai

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import SessionEntity

class ForceActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.xml.activity_force) // <-- Probablement R.layout.activity_force à la place

        // Exemple d’appel
        lifecycleScope.launch {
            // Exemple : on construit l’objet SessionEntity
            val session = SessionEntity(
                type = "Force",
                date = System.currentTimeMillis(),
                details = "Squat 5x5 à 90kg, Soulevé de terre 5x5 à 110kg"
            )

            // Il faut initialiser le DAO avant de l'utiliser
            // Par exemple :
            // val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "my_db").build()
            // val sessionDao = db.sessionDao()

            // sessionDao.insertSession(session)
        }
    }
}
