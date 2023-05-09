package com.vpr.places_together.data.remote.dto

import com.vpr.places_together.data.local.entity.GroupPlaceCommentEntity
import com.vpr.places_together.domain.model.CommentPlace
import java.time.LocalDateTime

data class CommentPlaceDto(
    val id: Long,
    val groupPlace: GroupPlaceDto,
    val profile: ProfileDto,
    val commentText: String,
    val createdTimestamp: LocalDateTime
) {
    fun mapToCommentPlace(): CommentPlace {
        return CommentPlace(
            id = id,
            groupPlace = groupPlace.mapToGroupPlace(),
            profile = profile.mapToProfile(),
            commentText = commentText,
            createdTimestamp = createdTimestamp
        )
    }
    fun toGroupPlaceCommentEntity(): GroupPlaceCommentEntity {
        return GroupPlaceCommentEntity(
            groupPlaceCommentId = id,
            groupPlaceId = groupPlace.id,
            profileId = profile.id,
            commentText = commentText,
            createdTimestamp = createdTimestamp
        )
    }
}