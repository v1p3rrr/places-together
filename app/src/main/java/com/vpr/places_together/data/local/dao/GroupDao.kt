package com.vpr.places_together.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.vpr.places_together.data.local.entity.GroupEntity

@Dao
interface GroupDao {
    @Insert
    suspend fun insert(group: GroupEntity)

    @Query("SELECT * FROM groups WHERE groupId = :id")
    suspend fun getById(id: Long): GroupEntity?

    @Query("SELECT * FROM groups WHERE name LIKE '%' || :name || '%'")
    suspend fun searchByName(name: String): List<GroupEntity>

    @Query("SELECT * FROM groups WHERE name = :groupName")
    suspend fun getByName(groupName: String): GroupEntity?

    @Query("SELECT * FROM groups WHERE LOWER(name) LIKE '%' || LOWER(:partOfName) || '%'")
    suspend fun getByNameContainingIgnoreCase(partOfName: String): List<GroupEntity>

    @Transaction
    @Query("SELECT groups.* FROM groups JOIN group_memberships ON groups.groupId = group_memberships.group_id WHERE group_memberships.profile_id = :profileId")
    suspend fun getByMembershipsProfileId(profileId: Long): List<GroupEntity>

}
