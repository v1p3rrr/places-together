package com.vpr.places_together.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vpr.places_together.data.local.entity.GroupPlaceMarkEntity

@Dao
interface MarkPlaceDao {
    @Insert
    suspend fun insert(markPlace: GroupPlaceMarkEntity)

    @Query("SELECT * FROM group_place_marks WHERE groupPlaceMarkId = :id")
    suspend fun getById(id: Long): GroupPlaceMarkEntity?
}
