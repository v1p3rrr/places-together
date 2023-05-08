package com.vpr.places_together.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vpr.places_together.data.local.entity.ProfileEntity

@Dao
interface ProfileDao {
    @Insert
    suspend fun insert(profile: ProfileEntity)

    @Query("SELECT * FROM profiles WHERE profileId = :id")
    suspend fun getById(id: Long): ProfileEntity?
}
