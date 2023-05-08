package com.vpr.places_together.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vpr.places_together.data.local.entity.ProfileEntity
import com.vpr.places_together.utils.enums.FriendshipStatus

@Dao
interface ProfileDao {
    @Insert
    suspend fun insert(profile: ProfileEntity)

    @Query("SELECT * FROM profiles WHERE profileId = :id")
    suspend fun getById(id: Long): ProfileEntity?

    @Query("SELECT EXISTS (SELECT 1 FROM friendships WHERE request_id = :profileId AND status = :friendshipStatus AND accept_id = :profileAcceptId)")
    suspend fun existsByIdAndFriendshipAcceptStatusAndFriendshipAcceptProfileAcceptId(profileId: Long, friendshipStatus: FriendshipStatus, profileAcceptId: Long): Boolean

    @Query("SELECT EXISTS (SELECT 1 FROM friendships WHERE request_id = :profileId AND status = :friendshipStatus AND accept_id = :profileRequestId)")
    suspend fun existsByIdAndFriendshipRequestStatusAndFriendshipRequestProfileRequestId(profileId: Long, friendshipStatus: FriendshipStatus, profileRequestId: Long): Boolean

    @Query("SELECT EXISTS (SELECT 1 FROM friendships WHERE (request_id = :profileId1 AND status = :friendshipStatus1 AND accept_id = :profileRequestId) OR (request_id = :profileId2 AND status = :friendshipStatus2 AND accept_id = :profileAcceptId))")
    suspend fun existsByIdAndFriendshipRequestStatusAndFriendshipRequestProfileRequestIdOrIdAndFriendshipAcceptStatusAndFriendshipAcceptProfileAcceptId(profileId1: Long, friendshipStatus1: FriendshipStatus, profileRequestId: Long, profileId2: Long, friendshipStatus2: FriendshipStatus, profileAcceptId: Long): Boolean

    @Query("SELECT DISTINCT * FROM profiles WHERE profileId IN (SELECT request_id FROM friendships WHERE request_id = :profileRequestId AND status = :friendshipStatus1) OR profileId IN (SELECT accept_id FROM friendships WHERE accept_id = :profileAcceptId AND status = :friendshipStatus2)")
    suspend fun findByFriendshipRequestProfileRequestIdAndFriendshipRequestStatusOrFriendshipAcceptProfileAcceptIdAndFriendshipAcceptStatus(profileRequestId: Long, friendshipStatus1: FriendshipStatus, profileAcceptId: Long, friendshipStatus2: FriendshipStatus): List<ProfileEntity>

    @Query("SELECT DISTINCT * FROM profiles WHERE profileId IN (SELECT accept_id FROM friendships WHERE request_id = :profileId AND status = :friendshipStatus)")
    suspend fun findByFriendshipAcceptProfileAcceptIdAndFriendshipAcceptStatus(profileId: Long, friendshipStatus: FriendshipStatus): List<ProfileEntity>

    @Query("SELECT DISTINCT * FROM profiles WHERE profileId IN (SELECT request_id FROM friendships WHERE accept_id = :profileId AND status = :friendshipStatus)")
    suspend fun findByFriendshipRequestProfileRequestIdAndFriendshipRequestStatus(profileId: Long, friendshipStatus: FriendshipStatus): List<ProfileEntity>

}
