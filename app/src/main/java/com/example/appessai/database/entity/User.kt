package com.example.appessai.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey val id: Int = 1,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val weight: Float,
    val height: Int
)
