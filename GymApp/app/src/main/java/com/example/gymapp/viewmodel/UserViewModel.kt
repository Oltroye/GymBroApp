package com.example.gymapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymapp.data.entities.User
import com.example.gymapp.GymApp
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    fun insertUser(user: User) {
        viewModelScope.launch {
            GymApp.database.userDao().insertUser(user)
        }
    }
}
