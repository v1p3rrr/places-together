package com.vpr.places_together.data.remote.dto

data class ProfileDto(
    val id: Long,
    val username: String,
    val profilePictureLink: String?,
    val status: String
)