package com.vpr.places_together.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vpr.places_together.data.local.entity.AccountEntity

@Dao
interface AccountDao {
    @Insert
    suspend fun insert(account: AccountEntity)

    @Query("SELECT * FROM accounts WHERE accountId = :id")
    suspend fun getById(id: Long): AccountEntity?

    @Query("SELECT * FROM accounts WHERE email = :email")
    suspend fun getByEmail(email: String): AccountEntity?
}
