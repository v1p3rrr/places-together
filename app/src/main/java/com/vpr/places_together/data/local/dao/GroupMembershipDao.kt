package com.vpr.places_together.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vpr.places_together.data.local.entity.GroupMembershipEntity

@Dao
interface GroupMembershipDao {
    @Insert
    suspend fun insert(groupMembership: GroupMembershipEntity)

    @Query("SELECT * FROM group_memberships WHERE groupMembershipId = :id")
    suspend fun getById(id: Long): GroupMembershipEntity?

    @Query("SELECT * FROM group_memberships WHERE group_id = :groupId")
    suspend fun getByGroupId(groupId: Long): List<GroupMembershipEntity>

    @Query("SELECT * FROM group_memberships WHERE profile_id = :profileId")
    suspend fun getByProfileId(profileId: Long): List<GroupMembershipEntity>

    @Query("SELECT * FROM group_memberships WHERE group_id = :groupId AND profile_id = :profileId")
    suspend fun getByGroupIdAndProfileId(groupId: Long, profileId: Long): GroupMembershipEntity?

}
