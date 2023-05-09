package com.vpr.places_together.data.remote.dto

import com.vpr.places_together.data.local.entity.PlaceEntity
import com.vpr.places_together.domain.model.Place


data class PlaceDto(
    val id: Long,
    val dgisId: Long,
    val name: String,
    val type: String,
    val address: String,
    val longitude: Double,
    val latitude: Double,
    val groupPlaces: List<GroupPlaceDto>
) {
    fun mapToPlace(): Place {
        return Place(
            id = id,
            dgisId = dgisId,
            name = name,
            type = type,
            address =address,
            longitude = longitude,
            latitude = latitude,
            groupPlaces = groupPlaces.map { it.mapToGroupPlace() }
        )
    }
    fun mapToPlaceEntity() = PlaceEntity(
    placeId = id,
    dgisId = dgisId,
    name = name,
    type = type,
    address = address,
    longitude = longitude,
    latitude = latitude
    )
}