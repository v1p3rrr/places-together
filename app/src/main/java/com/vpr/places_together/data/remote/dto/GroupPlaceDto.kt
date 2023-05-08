package com.vpr.places_together.data.remote.dto

data class GroupPlaceDto(
    val id: Long,
    val group: GroupDto,
    val place: PlaceDto,
    val markPlaces: Set<MarkPlaceDto>,
    val ratingPlaces: Set<RatingPlaceDto>,
    val commentPlaces: Set<CommentPlaceDto>
)