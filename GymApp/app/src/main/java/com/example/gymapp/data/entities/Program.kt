package com.example.gymapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "program")
data class Program(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val type: String, // ex : "Force", "Hypertrophie", "HIIT", "Custom"
    val description: String
)
