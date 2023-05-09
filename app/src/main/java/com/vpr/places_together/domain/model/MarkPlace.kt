package com.vpr.places_together.domain.model

import com.vpr.places_together.utils.enums.MarkPlaceStatus

data class MarkPlace(
val id: Long,
val groupPlace: GroupPlace,
val profile: Profile,
val status: MarkPlaceStatus
)