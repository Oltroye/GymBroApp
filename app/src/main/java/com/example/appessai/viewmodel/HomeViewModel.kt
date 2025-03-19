package com.example.appessai.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class HomeViewModel : ViewModel() {
    private val _welcomeMessage = MutableLiveData("Bienvenue dans ton application de musculation !")
    val welcomeMessage: LiveData<String> = _welcomeMessage
}
