package com.vpr.places_together.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vpr.places_together.data.local.entity.PlaceEntity

@Dao
interface PlaceDao {
    @Insert
    suspend fun insert(place: PlaceEntity)

    @Query("SELECT * FROM places WHERE placeId = :id")
    suspend fun getById(id: Long): PlaceEntity?

    @Query("SELECT * FROM places WHERE dgis_id = :dgisId")
    suspend fun getByDgisId(dgisId: Long): PlaceEntity?

    @Query("SELECT * FROM places WHERE longitude BETWEEN :minLongitude AND :maxLongitude AND latitude BETWEEN :minLatitude AND :maxLatitude")
    suspend fun getByLocation(minLongitude: Long, maxLongitude: Long, minLatitude: Long, maxLatitude: Long): List<PlaceEntity>
}
