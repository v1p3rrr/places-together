package com.vpr.places_together.data.remote.dto

import com.vpr.places_together.data.local.entity.GroupPlaceMarkEntity
import com.vpr.places_together.domain.model.MarkPlace
import com.vpr.places_together.utils.enums.MarkPlaceStatus

data class MarkPlaceDto(
    val id: Long,
    val groupPlace: GroupPlaceDto,
    val profile: ProfileDto,
    val status: MarkPlaceStatus
) {
    fun mapToMarkPlace(): MarkPlace {
        return MarkPlace(
            id = id,
            groupPlace = groupPlace.mapToGroupPlace(),
            profile = profile.mapToProfile(),
            status = status
        )
    }
    fun toGroupPlaceMarkEntity(): GroupPlaceMarkEntity {
        return GroupPlaceMarkEntity(
            group_place_id = groupPlace.id,
            profile_id = profile.id,
            status = status
        )
    }
}