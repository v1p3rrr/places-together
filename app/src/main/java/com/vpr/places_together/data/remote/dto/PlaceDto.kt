package com.vpr.places_together.data.remote.dto

data class PlaceDto(
    val id: Long,
    val dgisId: Long,
    val name: String,
    val type: String,
    val address: String,
    val longitude: Long,
    val latitude: Long,
    val groupPlaces: Set<GroupPlaceDto>
)