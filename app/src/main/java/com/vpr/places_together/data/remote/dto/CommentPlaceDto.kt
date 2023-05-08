package com.vpr.places_together.data.remote.dto

import java.time.LocalDateTime

data class CommentPlaceDto(
    val id: Long,
    val groupPlace: GroupPlaceDto,
    val profile: ProfileDto,
    val commentText: String,
    val createdTimestamp: LocalDateTime
)