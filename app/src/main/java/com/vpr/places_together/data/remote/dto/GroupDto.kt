package com.vpr.places_together.data.remote.dto

data class GroupDto(
    val id: Long,
    val name: String,
    val groupPictureLink: String,
    val members: Set<ProfileDto>,
    val groupPlaces: Set<GroupPlaceDto>
)