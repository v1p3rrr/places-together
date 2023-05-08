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

    @Query("SELECT * FROM group_places WHERE group_id = :groupId")
    suspend fun getByGroupId(groupId: Long): List<GroupPlaceEntity>

    @Query("SELECT * FROM group_places WHERE place_id = :placeId")
    suspend fun getByPlaceId(placeId: Long): List<GroupPlaceEntity>

    @Query("SELECT * FROM group_places WHERE group_id = :groupId AND place_id IN (SELECT placeId FROM places WHERE address LIKE '%' || :address || '%')")
    suspend fun getByGroupIdAndPlaceAddress(groupId: Long, address: String): List<GroupPlaceEntity>

    @Query("SELECT * FROM group_places WHERE group_id = :groupId AND place_id IN (SELECT placeId FROM places WHERE name LIKE '%' || :partOfName || '%')")
    suspend fun getByGroupIdAndPlacePartOfName(groupId: Long, partOfName: String): List<GroupPlaceEntity>

    @Query("SELECT * FROM group_places WHERE group_id = :groupId AND place_id IN (SELECT placeId FROM places WHERE type = :placeType)")
    suspend fun getByGroupIdAndPlaceType(groupId: Long, placeType: String): List<GroupPlaceEntity>

    @Query("SELECT * FROM group_places WHERE group_id = :groupId AND place_id IN (SELECT placeId FROM places WHERE name = :placeName)")
    suspend fun getByGroupIdAndPlaceName(groupId: Long, placeName: String): GroupPlaceEntity?

    @Query("SELECT * FROM group_places WHERE group_id = :groupId AND place_id IN (SELECT placeId FROM places WHERE dgis_id = :dgisId)")
    suspend fun getByGroupIdAndPlaceDgisId(groupId: Long, dgisId: Long): GroupPlaceEntity?

}
