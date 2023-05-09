package com.vpr.places_together.domain.model

data class GroupPlace(
val id: Long,
val group: Group,
val place: Place,
val markPlaces: List<MarkPlace>,
val ratingPlaces: List<RatingPlace>,
val commentPlaces: List<CommentPlace>
)