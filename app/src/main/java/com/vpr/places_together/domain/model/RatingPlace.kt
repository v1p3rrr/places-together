package com.vpr.places_together.domain.model

data class RatingPlace(
val id: Long,
val groupPlace: GroupPlace,
val profile: Profile,
val stars: Int
)