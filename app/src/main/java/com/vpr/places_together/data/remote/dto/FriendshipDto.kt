package com.vpr.places_together.data.remote.dto

import com.vpr.places_together.data.local.entity.FriendshipEntity
import com.vpr.places_together.domain.model.Friendship
import com.vpr.places_together.utils.enums.FriendshipStatus

data class FriendshipDto(
    val id: Long,
    val profileRequest: ProfileDto,
    val profileAccept: ProfileDto,
    val status: FriendshipStatus
) {
    fun mapToFriendship(): Friendship {
        return Friendship(
            id = this.id,
            profileRequest = this.profileRequest.mapToProfile(),
            profileAccept = this.profileAccept.mapToProfile(),
            status = this.status
        )
    }

    fun toFriendshipEntity(): FriendshipEntity {
        return FriendshipEntity(
            friendshipId = this.id,
            profileRequestId = this.profileRequest.id,
            profileAcceptId = this.profileAccept.id,
            status = this.status
        )
    }
}