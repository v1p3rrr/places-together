package com.vpr.places_together.domain.model

data class Profile(
val id: Long,
val username: String,
val profilePictureLink: String?,
val status: String
)