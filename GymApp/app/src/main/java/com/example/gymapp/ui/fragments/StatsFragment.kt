package com.example.gymapp.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gymapp.databinding.FragmentStatsBinding
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter


class StatsFragment : Fragment() {

    private var _binding: FragmentStatsBinding? = null
    private val binding get() = _binding!!

    private val entries: List<Entry> by lazy {
        listOf(
            Entry(0f, 50f),
            Entry(1f, 55f),
            Entry(2f, 60f)
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentStatsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupChart()
        updateSessionCount()
    }

    private fun setupChart() {
        val dataSet = LineDataSet(entries, "Progression du Poids").apply {
            lineWidth = 2f
            color = Color.BLUE
            setCircleColor(Color.BLUE)
            circleRadius = 4f
            setDrawValues(true)
            valueTextSize = 10f
            mode = LineDataSet.Mode.LINEAR
        }

        binding.lineChart.apply {
            data = LineData(dataSet)
            description = Description().apply {
                text = "Évolution du poids"
                textSize = 12f
            }
            
            xAxis.apply {
                position = XAxis.XAxisPosition.BOTTOM
                setDrawGridLines(false)
                valueFormatter = object : ValueFormatter() {
                    override fun getFormattedValue(value: Float): String {
                        return "Sem ${value.toInt() + 1}"
                    }
                }
            }

            axisLeft.apply {
                setDrawGridLines(true)
                valueFormatter = object : ValueFormatter() {
                    override fun getFormattedValue(value: Float): String {
                        return "${value.toInt()} kg"
                    }
                }
            }

            axisRight.isEnabled = false
            setTouchEnabled(true)
            isDragEnabled = true
            setScaleEnabled(true)
            setPinchZoom(true)
            animateX(1000)
        }
    }

    private fun updateSessionCount() {
        binding.tvSessionsCount.text = "Total de séances: ${entries.size}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
