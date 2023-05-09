package com.vpr.places_together.domain.model

import com.vpr.places_together.utils.enums.GroupMemberRole

data class GroupMembership(
val id: Long,
val group: Group,
val profile: Profile,
val role: GroupMemberRole
)