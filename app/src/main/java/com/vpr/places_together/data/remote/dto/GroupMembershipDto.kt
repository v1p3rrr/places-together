
package com.vpr.places_together.data.remote.dto

import com.vpr.places_together.data.local.entity.GroupMembershipEntity
import com.vpr.places_together.domain.model.GroupMembership
import com.vpr.places_together.utils.enums.GroupMemberRole


data class GroupMembershipDto(
    val id: Long,
    val group: GroupDto,
    val profile: ProfileDto,
    val role: GroupMemberRole
) {
    fun mapToGroupMembership(): GroupMembership {
        return GroupMembership(
            id = id,
            group = group.mapToGroup(),
            profile = profile.mapToProfile(),
            role = role
        )
    }
    fun toGroupMembershipEntity(): GroupMembershipEntity {
        return GroupMembershipEntity(
            group_id = this.group.id,
            profile_id = this.profile.id,
            role = this.role
        )
    }
}