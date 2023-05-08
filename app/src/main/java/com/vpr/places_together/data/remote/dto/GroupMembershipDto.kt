
package com.vpr.places_together.data.remote.dto

data class GroupMembershipDto(
    val id: Long,
    val group: GroupDto,
    val profile: ProfileDto,
    val isModerator: Boolean
)