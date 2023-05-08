package com.vpr.places_together.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomWarnings
import androidx.room.Transaction
import com.vpr.places_together.data.local.entity.GroupPlaceCommentEntity

@Dao
interface CommentPlaceDao {
    @Insert
    suspend fun insert(commentPlace: GroupPlaceCommentEntity)

    @Query("SELECT * FROM group_place_comments WHERE groupPlaceCommentId = :id")
    suspend fun getById(id: Long): GroupPlaceCommentEntity?

    @Query("SELECT * FROM group_place_comments WHERE groupPlaceCommentId = :id AND group_place_id = :groupPlaceId LIMIT 1")
    suspend fun getByIdAndGroupPlaceId(id: Long, groupPlaceId: Long): GroupPlaceCommentEntity?

    @Query("SELECT * FROM group_place_comments WHERE group_place_id = :groupId AND profile_id = :profileId")
    suspend fun getByGroupIdAndProfileId(groupId: Long, profileId: Long): List<GroupPlaceCommentEntity>

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Transaction
    @Query("SELECT * FROM group_place_comments INNER JOIN group_places ON group_place_comments.group_place_id = group_places.groupPlaceId INNER JOIN places ON group_places.place_id = places.placeId WHERE group_places.group_id = :groupId AND places.dgis_id = :dgisId")
    suspend fun getByGroupIdAndPlaceDgisId(groupId: Long, dgisId: Long): List<GroupPlaceCommentEntity>

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Transaction
    @Query("SELECT * FROM group_place_comments INNER JOIN group_places ON group_place_comments.group_place_id = group_places.groupPlaceId INNER JOIN places ON group_places.place_id = places.placeId WHERE group_places.group_id = :groupId AND places.name = :placeName")
    suspend fun getByGroupIdAndPlaceName(groupId: Long, placeName: String): List<GroupPlaceCommentEntity>

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Transaction
    @Query("SELECT * FROM group_place_comments INNER JOIN group_places ON group_place_comments.group_place_id = group_places.groupPlaceId INNER JOIN places ON group_places.place_id = places.placeId WHERE group_places.group_id = :groupId AND profile_id = :profileId AND places.dgis_id = :dgisId LIMIT 1")
    suspend fun getByGroupIdAndProfileIdAndPlaceDgisId(groupId: Long, profileId: Long, dgisId: Long): GroupPlaceCommentEntity?

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Transaction
    @Query("SELECT * FROM group_place_comments INNER JOIN group_places ON group_place_comments.group_place_id = group_places.groupPlaceId INNER JOIN places ON group_places.place_id = places.placeId WHERE group_places.group_id = :groupId AND profile_id = :profileId AND places.name = :placeName LIMIT 1")
    suspend fun getByGroupIdAndProfileIdAndPlaceName(groupId: Long, profileId: Long, placeName: String): GroupPlaceCommentEntity?

}
