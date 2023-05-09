package com.vpr.places_together.domain.model

data class Place(
val id: Long,
val dgisId: Long,
val name: String,
val type: String,
val address: String,
val longitude: Double,
val latitude: Double,
val groupPlaces: List<GroupPlace>
)