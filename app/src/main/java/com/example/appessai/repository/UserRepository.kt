package com.example.appessai.repository

import com.example.appessai.database.dao.UserDao
import com.example.appessai.database.entity.User
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {
    val user: Flow<User> = userDao.getUser()

    suspend fun insertOrUpdate(user: User) {
        userDao.insertOrUpdate(user)
    }
}
