package com.vpr.places_together.data.remote.dto

import com.vpr.places_together.data.local.entity.ProfileEntity
import com.vpr.places_together.domain.model.Profile

data class ProfileDto(
    val id: Long,
    val username: String,
    val profilePictureLink: String?,
    val status: String
) {
    fun mapToProfile(): Profile {
        return Profile(
            id = id,
            username = username,
            profilePictureLink = profilePictureLink,
            status = status
        )
    }
    fun mapToProfileEntity(): ProfileEntity {
        return ProfileEntity(
            profileId = this.id,
            username = this.username,
            profilePictureLink = this.profilePictureLink,
            status = this.status
        )
    }
}