package com.vpr.places_together.data.remote.dto

import com.vpr.places_together.data.local.entity.GroupPlaceRatingEntity
import com.vpr.places_together.domain.model.RatingPlace

data class RatingPlaceDto(
    val id: Long,
    val groupPlace: GroupPlaceDto,
    val profile: ProfileDto,
    val stars: Int
) {
    fun mapToRatingPlace(): RatingPlace {
        return RatingPlace(
            id = id,
            groupPlace = groupPlace.mapToGroupPlace(),
            profile = profile.mapToProfile(),
            stars = stars
        )
    }
    fun RatingPlaceDto.toGroupPlaceRatingEntity(): GroupPlaceRatingEntity {
        return GroupPlaceRatingEntity(
            group_place_id = groupPlace.id,
            profile_id = profile.id,
            stars = stars
        )
    }
}