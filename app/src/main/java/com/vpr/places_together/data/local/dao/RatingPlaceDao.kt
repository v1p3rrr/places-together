package com.vpr.places_together.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vpr.places_together.data.local.entity.GroupPlaceRatingEntity

@Dao
interface RatingPlaceDao {
    @Insert
    suspend fun insert(ratingPlace: GroupPlaceRatingEntity)

    @Query("SELECT * FROM group_place_ratings WHERE groupPlaceRatingId = :id")
    suspend fun getById(id: Long): GroupPlaceRatingEntity?
}
