package com.vpr.places_together.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profiles")
data class ProfileEntity(
    @PrimaryKey(autoGenerate = true) val profileId: Long = 0,
    val username: String,
    val profilePictureLink: String?,
    val status: String
)