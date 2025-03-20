package com.example.gymapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.gymapp.databinding.FragmentProgramSelectionBinding

class ProgramSelectionFragment : Fragment() {

    private var _binding: FragmentProgramSelectionBinding? = null
    private val binding get() = _binding!!

    private val programs = listOf("Force", "Hypertrophie", "HIIT", "Personnalisé")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgramSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Pour chaque programme, créez dynamiquement un bouton
        programs.forEach { program ->
            val button = android.widget.Button(requireContext()).apply {
                text = program
                setOnClickListener {
                    // Utilise Safe Args pour naviguer
                    val action = ProgramSelectionFragmentDirections
                        .actionProgramSelectionFragmentToSessionSummaryFragment(program)
                    findNavController().navigate(action)
                }
            }
            // Ajoutez le bouton au conteneur du layout
            binding.programContainer.addView(button)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
