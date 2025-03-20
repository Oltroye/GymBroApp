package com.example.gymapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.gymapp.R
import com.example.gymapp.databinding.FragmentSessionSummaryBinding

class SessionSummaryFragment : Fragment() {

    private var _binding: FragmentSessionSummaryBinding? = null
    private val binding get() = _binding!!

    private val args: SessionSummaryFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSessionSummaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvSummary.text = getString(R.string.session_summary, args.programType)

        binding.btnStartSession.setOnClickListener {

            val action = SessionSummaryFragmentDirections
                .actionSessionSummaryFragmentToTrainingFragment(args.programType)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
