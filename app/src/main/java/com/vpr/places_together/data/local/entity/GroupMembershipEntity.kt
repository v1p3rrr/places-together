package com.vpr.places_together.data.local.entity;

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.vpr.places_together.utils.enums.GroupMemberRole

@Entity(tableName = "group_memberships",
    foreignKeys = [
        ForeignKey(
            entity = GroupEntity::class,
            parentColumns = ["groupId"],
            childColumns = ["group_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ProfileEntity::class,
            parentColumns = ["profileId"],
            childColumns = ["profile_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["group_id"]),
        Index(value = ["profile_id"])
    ]
)
data class GroupMembershipEntity(
    @PrimaryKey(autoGenerate = true) val groupMembershipId: Long = 0,
    val group_id: Long,
    val profile_id: Long,
    val role: GroupMemberRole
)