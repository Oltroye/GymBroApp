package com.example.appessai.database.dao

import androidx.room.*
import com.example.appessai.database.entity.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table WHERE id = 1")
    fun getUser(): Flow<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(user: User)
}
