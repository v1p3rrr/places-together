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
}
