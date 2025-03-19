package com.example.appessai.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import java.util.UUID


@Entity(tableName = "user")
data class User(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val name: String,
    val age: Int,
    val weight: Float,
    val height: Float,
    val create: Long = System.currentTimeMillis()
)
