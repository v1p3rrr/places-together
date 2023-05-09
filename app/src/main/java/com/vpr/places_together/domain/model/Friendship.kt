package com.vpr.places_together.domain.model

import com.vpr.places_together.utils.enums.FriendshipStatus

data class Friendship(
val id: Long,
val profileRequest: Profile,
val profileAccept: Profile,
val status: FriendshipStatus
)