package com.vpr.places_together.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vpr.places_together.data.local.entity.GroupPlaceCommentEntity

@Dao
interface CommentPlaceDao {
    @Insert
    suspend fun insert(commentPlace: GroupPlaceCommentEntity)

    @Query("SELECT * FROM group_place_comments WHERE groupPlaceCommentId = :id")
    suspend fun getById(id: Long): GroupPlaceCommentEntity?
}
