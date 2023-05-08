package com.vpr.places_together.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "group_place_ratings",
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
data class GroupPlaceRatingEntity(
    @PrimaryKey(autoGenerate = true) val groupPlaceRatingId: Long = 0,
    val group_place_id: Long,
    val profile_id: Long,
    val stars: Int
)