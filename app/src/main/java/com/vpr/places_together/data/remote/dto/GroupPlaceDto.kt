package com.vpr.places_together.data.remote.dto

import com.vpr.places_together.data.local.entity.GroupPlaceEntity
import com.vpr.places_together.domain.model.GroupPlace

data class GroupPlaceDto(
    val id: Long,
    val group: GroupDto,
    val place: PlaceDto,
    val markPlaces: List<MarkPlaceDto>,
    val ratingPlaces: List<RatingPlaceDto>,
    val commentPlaces: List<CommentPlaceDto>
) {
    fun mapToGroupPlace(): GroupPlace {
        return GroupPlace(
            id = id,
            group = group.mapToGroup(),
            place = place.mapToPlace(),
            markPlaces = markPlaces.map { it.mapToMarkPlace() },
            ratingPlaces = ratingPlaces.map { it.mapToRatingPlace() },
            commentPlaces = commentPlaces.map { it.mapToCommentPlace() }
        )
    }
    fun mapToGroupPlaceEntity(groupPlaceDto: GroupPlaceDto): GroupPlaceEntity {
        return GroupPlaceEntity(
            group_id = groupPlaceDto.group.id,
            place_id = groupPlaceDto.place.id
        )
    }
}