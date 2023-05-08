package com.vpr.places_together.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.Index
import androidx.room.PrimaryKey
import com.vpr.places_together.utils.enums.FriendshipStatus

@Entity(
    tableName = "friendships", foreignKeys = [
        ForeignKey(
            entity = ProfileEntity::class,
            parentColumns = ["profileId"],
            childColumns = ["request_id"],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = ProfileEntity::class,
            parentColumns = ["profileId"],
            childColumns = ["accept_id"],
            onDelete = CASCADE
        )
    ],
//    indices = [
//        Index(value = ["request_id"], name = "index_friendships_request_id"),
//        Index(value = ["accept_id"], name = "index_friendships_accept_id")
//    ]
)
data class FriendshipEntity(
    @PrimaryKey val friendshipId: Long,
    @ColumnInfo(name = "request_id", index = true) val profileRequestId: Long,
    @ColumnInfo(name = "accept_id", index = true) val profileAcceptId: Long,
    val status: FriendshipStatus
)