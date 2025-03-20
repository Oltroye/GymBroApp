package com.example.gymapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gymapp.data.entities.Program

@Dao
interface ProgramDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProgram(program: Program)

    @Query("SELECT * FROM program")
    suspend fun getAllPrograms(): List<Program>
}
