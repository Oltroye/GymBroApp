package com.example.gymapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.gymapp.databinding.FragmentTrainingBinding

class TrainingFragment : Fragment() {

    private var _binding: FragmentTrainingBinding? = null
    private val binding get() = _binding!!
    private val args: TrainingFragmentArgs by navArgs()

    private val exercises = listOf("Exercice 1", "Exercice 2", "Exercice 3")
    private var currentExerciseIndex = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTrainingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        showExercise()

        binding.btnNextExercise.setOnClickListener {
            currentExerciseIndex++
            if (currentExerciseIndex < exercises.size) {
                showExercise()
            } else {
                findNavController().navigate(TrainingFragmentDirections.actionTrainingFragmentToStatsFragment())
            }
        }
    }

    private fun showExercise() {
        val exercise = exercises[currentExerciseIndex]
        binding.tvExerciseName.text = exercise
        binding.tvExerciseDetails.text = "3 séries de 10 répétitions avec 50kg"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
