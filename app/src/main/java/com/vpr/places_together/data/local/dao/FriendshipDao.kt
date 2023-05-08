package com.vpr.places_together.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vpr.places_together.data.local.entity.FriendshipEntity

@Dao
interface FriendshipDao {
    @Insert
    suspend fun insert(friendship: FriendshipEntity)

    @Query("SELECT * FROM friendships WHERE friendshipId = :id")
    suspend fun getById(id: Long): FriendshipEntity?

    @Query("SELECT * FROM friendships WHERE request_id = :profileRequestId AND accept_id = :profileAcceptId")
    suspend fun getByProfileRequestIdAndProfileAcceptId(profileRequestId: Long, profileAcceptId: Long): FriendshipEntity?

    @Query("SELECT status FROM friendships WHERE request_id = :profileRequestId AND accept_id = :profileAcceptId")
    suspend fun getFriendshipStatusByProfileRequestIdAndProfileAcceptId(profileRequestId: Long, profileAcceptId: Long): String?

    @Query("SELECT * FROM friendships WHERE request_id = :profileRequestId")
    suspend fun getByProfileRequestId(profileRequestId: Long): List<FriendshipEntity>

    @Query("SELECT * FROM friendships WHERE accept_id = :profileAcceptId")
    suspend fun getByProfileAcceptId(profileAcceptId: Long): List<FriendshipEntity>
}
