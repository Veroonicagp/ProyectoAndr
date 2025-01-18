package com.example.readytoenjoy.core.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert//(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createUser(user:UserEntity)

    @Query("SELECT * FROM user LIMIT 1")
    suspend fun getUser(): UserEntity?

}