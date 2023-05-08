package com.vpr.places_together.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vpr.places_together.data.local.entity.GroupPlaceEntity
import com.vpr.places_together.data.local.entity.GroupPlaceMarkEntity
import com.vpr.places_together.data.local.entity.ProfileEntity

@Dao
interface MarkPlaceDao {
    @Insert
    suspend fun insert(markPlace: GroupPlaceMarkEntity)

    @Query("SELECT * FROM group_place_marks WHERE groupPlaceMarkId = :id")
    suspend fun getById(id: Long): GroupPlaceMarkEntity?

    @Query("SELECT * FROM group_place_marks WHERE profile_id = :profileId AND group_place_id IN (SELECT group_place_id FROM group_places WHERE group_id = :groupId)")
    suspend fun getByProfileIdAndGroupId(profileId: Long, groupId: Long): List<GroupPlaceMarkEntity>

    @Query("SELECT * FROM group_place_marks WHERE groupPlaceMarkId = :id AND profile_id = :profileId AND group_place_id IN (SELECT group_place_id FROM group_places WHERE group_id = :groupId)")
    suspend fun getByIdAndProfileIdAndGroupId(id: Long, profileId: Long, groupId: Long): List<GroupPlaceMarkEntity>

    @Query("SELECT * FROM group_place_marks WHERE group_place_id IN (SELECT group_place_id FROM group_places WHERE group_id = :groupId) AND group_place_id IN (SELECT placeId FROM places WHERE dgis_id = :dgisId)")
    suspend fun getByGroupIdAndPlaceDgisId(groupId: Long, dgisId: Long): List<GroupPlaceMarkEntity>

    @Query("SELECT * FROM group_place_marks WHERE group_place_id IN (SELECT group_place_id FROM group_places WHERE group_id = :groupId) AND group_place_id IN (SELECT placeId FROM places WHERE name = :placeName)")
    suspend fun getByGroupIdAndPlaceName(groupId: Long, placeName: String): List<GroupPlaceMarkEntity>

    @Query("SELECT * FROM group_place_marks WHERE group_place_id IN (SELECT group_place_id FROM group_places WHERE group_id = :groupId) AND profile_id = :profileId AND group_place_id IN (SELECT placeId FROM places WHERE name = :placeName)")
    suspend fun getByGroupIdAndProfileIdAndPlaceName(groupId: Long, profileId: Long, placeName: String): GroupPlaceMarkEntity?

    @Query("SELECT * FROM group_place_marks WHERE group_place_id IN (SELECT group_place_id FROM group_places WHERE group_id = :groupId) AND profile_id = :profileId AND group_place_id IN (SELECT placeId FROM places WHERE dgis_id = :dgisId)")
    suspend fun getByGroupIdAndProfileIdAndPlaceDgisId(groupId: Long, profileId: Long, dgisId: Long): GroupPlaceMarkEntity?

    @Query("SELECT * FROM group_place_marks WHERE group_place_id IN (SELECT group_place_id FROM group_places WHERE group_id = :groupId)")
    suspend fun getByGroupId(groupId: Long): List<GroupPlaceMarkEntity>

}
