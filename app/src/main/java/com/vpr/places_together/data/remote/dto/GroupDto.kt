package com.vpr.places_together.data.remote.dto

import com.vpr.places_together.data.local.entity.GroupEntity
import com.vpr.places_together.domain.model.Group

data class GroupDto(
    val id: Long,
    val name: String,
    val groupPictureLink: String = "",
    val members: List<ProfileDto>,
    val groupPlaces: List<GroupPlaceDto>
) {
    fun mapToGroup(): Group {
        return Group(
            id = id,
            name = name,
            groupPictureLink = groupPictureLink,
            members = members.map { it.mapToProfile() },
            groupPlaces = groupPlaces.map { it.mapToGroupPlace() }
        )
    }
    fun mapToGroupEntity() = GroupEntity(
    groupId = id,
    name = name,
    groupPictureLink = groupPictureLink
    )
}