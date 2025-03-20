package com.example.gymapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.gymapp.data.entities.User
import com.example.gymapp.databinding.FragmentUserInputBinding
import com.example.gymapp.GymApp
import kotlinx.coroutines.launch

class UserInputFragment : Fragment() {

    private var _binding: FragmentUserInputBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentUserInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnSaveUser.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val age = binding.etAge.text.toString().toIntOrNull() ?: 0
            val height = binding.etHeight.text.toString().toFloatOrNull() ?: 0f
            val weight = binding.etWeight.text.toString().toFloatOrNull() ?: 0f

            if (firstName.isNotEmpty() && lastName.isNotEmpty() && age > 0 && height > 0 && weight > 0) {
                val user = User(firstName = firstName, lastName = lastName, age = age, height = height, weight = weight)
                lifecycleScope.launch {
                    GymApp.database.userDao().insertUser(user)
                    findNavController().navigate(UserInputFragmentDirections.actionUserInputFragmentToProgramSelectionFragment())
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
