package com.vpr.places_together.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.vpr.places_together.utils.enums.MarkPlaceStatus

@Entity(tableName = "group_place_marks",
    foreignKeys = [
        ForeignKey(
            entity = GroupPlaceEntity::class,
            parentColumns = ["groupPlaceId"],
            childColumns = ["group_place_id"],
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
        Index(value = ["group_place_id"]),
        Index(value = ["profile_id"])
    ]
)
data class GroupPlaceMarkEntity(
    @PrimaryKey(autoGenerate = true) val groupPlaceMarkId: Long = 0,
    val group_place_id: Long,
    val profile_id: Long,
    val status: MarkPlaceStatus
)