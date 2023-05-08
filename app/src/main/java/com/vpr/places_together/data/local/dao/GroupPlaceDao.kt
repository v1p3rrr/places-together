package com.vpr.places_together.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vpr.places_together.data.local.entity.GroupPlaceEntity

@Dao
interface GroupPlaceDao {
    @Insert
    suspend fun insert(groupPlace: GroupPlaceEntity)

    @Query("SELECT * FROM group_places WHERE groupPlaceId = :id")
    suspend fun getById(id: Long): GroupPlaceEntity?
}
