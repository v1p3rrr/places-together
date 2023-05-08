package com.vpr.places_together.data.remote.dto

data class MarkPlaceDto(
    val id: Long,
    val groupPlace: GroupPlaceDto,
    val profile: ProfileDto,
    val status: String
)