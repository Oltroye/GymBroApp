package com.example.gymapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "session")
data class Session(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val date: Long, // timestamp
    val programType: String,
    val weightUsed: Float,
    val sessionsCount: Int
)
