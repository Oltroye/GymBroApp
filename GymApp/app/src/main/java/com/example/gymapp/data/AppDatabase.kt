package com.example.gymapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gymapp.data.dao.ProgramDao
import com.example.gymapp.data.dao.SessionDao
import com.example.gymapp.data.dao.UserDao
import com.example.gymapp.data.entities.Program
import com.example.gymapp.data.entities.Session
import com.example.gymapp.data.entities.User

@Database(entities = [User::class, Program::class, Session::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun programDao(): ProgramDao
    abstract fun sessionDao(): SessionDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "gymapp_database"
                ).build().also { instance = it }
            }
    }
}
