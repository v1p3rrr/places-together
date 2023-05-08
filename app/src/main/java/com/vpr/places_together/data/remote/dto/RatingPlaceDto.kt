package com.vpr.places_together.data.remote.dto

data class RatingPlaceDto(
    val id: Long,
    val groupPlace: GroupPlaceDto,
    val profile: ProfileDto,
    val stars: Int
)