package com.vpr.places_together.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vpr.places_together.data.local.dao.*
import com.vpr.places_together.data.local.entity.*
import com.vpr.places_together.data.local.typeconverter.LocalDateTimeConverter

@Database(
    entities = [
        AccountEntity::class,
        ProfileEntity::class,
        GroupEntity::class,
        GroupPlaceEntity::class,
        GroupPlaceMarkEntity::class,
        GroupPlaceRatingEntity::class,
        GroupPlaceCommentEntity::class,
        FriendshipEntity::class,
        PlaceEntity::class,
        GroupMembershipEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(LocalDateTimeConverter::class)
abstract class PlacesTogetherDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDao
    abstract fun profileDao(): ProfileDao
    abstract fun groupDao(): GroupDao
    abstract fun groupPlaceDao(): GroupPlaceDao
    abstract fun markPlaceDao(): MarkPlaceDao
    abstract fun ratingPlaceDao(): RatingPlaceDao
    abstract fun commentPlaceDao(): CommentPlaceDao
    abstract fun friendshipDao(): FriendshipDao
    abstract fun placeDao(): PlaceDao
    abstract fun groupMembershipDao(): GroupMembershipDao
}