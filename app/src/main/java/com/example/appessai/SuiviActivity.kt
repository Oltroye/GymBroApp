package com.example.appessai

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.appessai.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class SuiviActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suivi)

        // Récupère le LineChart défini dans le layout
        val lineChart = findViewById<LineChart>(R.id.lineChart)

        // Exemple statique de données
        val entries = mutableListOf<Entry>()
        entries.add(Entry(1f, 60f))   // Semaine 1 => 60 kg au bench
        entries.add(Entry(2f, 62.5f)) // Semaine 2 => 62.5 kg
        entries.add(Entry(3f, 65f))   // Semaine 3 => 65 kg

        val dataSet = LineDataSet(entries, "Progression Bench Press")
        val lineData = LineData(dataSet)

        // Timer d'exemple
        val timer = object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Mettre à jour l’UI, par ex. un TextView
            }

            override fun onFinish() {
                // Action à la fin du timer
            }
        }
        timer.start()

        // Assigner les données au chart et rafraîchir
        lineChart.data = lineData
        lineChart.invalidate()
    }
}

