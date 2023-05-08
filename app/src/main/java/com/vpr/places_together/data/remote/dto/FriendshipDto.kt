package com.vpr.places_together.data.remote.dto

import com.vpr.places_together.utils.enums.FriendshipStatus

data class FriendshipDto(
    val id: Long,
    val profileRequest: ProfileDto,
    val profileAccept: ProfileDto,
    val status: FriendshipStatus
)