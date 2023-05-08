package com.vpr.places_together.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(
    tableName = "group_place_comments",
    foreignKeys = [
        ForeignKey(
            entity = GroupPlaceEntity::class,
            parentColumns = ["groupPlaceId"],
            childColumns = ["group_place_id"],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = ProfileEntity::class,
            parentColumns = ["profileId"],
            childColumns = ["profile_id"],
            onDelete = CASCADE
        )
    ]
)
data class GroupPlaceCommentEntity(
    @PrimaryKey val groupPlaceCommentId: Long,
    @ColumnInfo(name = "group_place_id", index = true) val groupPlaceId: Long,
    @ColumnInfo(name = "profile_id", index = true) val profileId: Long,
    val commentText: String,
    val createdTimestamp: LocalDateTime
)