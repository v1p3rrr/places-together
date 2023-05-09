package com.vpr.places_together.domain.model

import java.time.LocalDateTime

data class CommentPlace(
val id: Long,
val groupPlace: GroupPlace,
val profile: Profile,
val commentText: String,
val createdTimestamp: LocalDateTime
)