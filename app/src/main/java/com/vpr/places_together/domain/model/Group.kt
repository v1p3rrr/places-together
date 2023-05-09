package com.vpr.places_together.domain.model

data class Group(
val id: Long,
val name: String,
val groupPictureLink: String,
val members: List<Profile>,
val groupPlaces: List<GroupPlace>
)