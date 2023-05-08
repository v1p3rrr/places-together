package com.vpr.places_together.data.remote.dto

data class FriendshipDto(
    val id: Long,
    val profileRequest: ProfileDto,
    val profileAccept: ProfileDto,
    val status: String
)