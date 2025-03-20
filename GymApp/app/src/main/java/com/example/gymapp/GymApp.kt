package com.example.gymapp

import android.app.Application
import com.example.gymapp.data.AppDatabase

class GymApp : Application() {
    companion object {
        private lateinit var instance: GymApp
        
        val database: AppDatabase by lazy {
            AppDatabase.getInstance(instance)
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
