import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_suivi)

    val lineChart = findViewById<LineChart>(R.id.lineChart)

    // Exemple statique :
    val entries = mutableListOf<Entry>()
    entries.add(Entry(1f, 60f))   // Semaine 1 => 60 kg au bench
    entries.add(Entry(2f, 62.5f)) // Semaine 2 => 62.5 kg
    entries.add(Entry(3f, 65f))   // Semaine 3 => 65 kg

    val dataSet = LineDataSet(entries, "Progression Bench Press")
    val lineData = LineData(dataSet)

    val timer = object : CountDownTimer(60000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            // Mettre à jour l’UI, par ex. un TextView
        }

        override fun onFinish() {
            // Action à la fin du timer
        }
    }
    timer.start()

    lineChart.data = lineData
    lineChart.invalidate() // rafraîchit le graph
}

