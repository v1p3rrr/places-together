package com.vpr.places_together.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(
    tableName = "places",
    indices = [Index(value = ["dgis_id"], unique = true)]
)
data class PlaceEntity(
    @PrimaryKey(autoGenerate = true)
    val placeId: Long = 0,

    @ColumnInfo(name = "dgis_id")
    val dgisId: Long,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "type")
    val type: String,

    @ColumnInfo(name = "address")
    val address: String,

    @ColumnInfo(name = "longitude")
    val longitude: Double,

    @ColumnInfo(name = "latitude")
    val latitude: Double
)