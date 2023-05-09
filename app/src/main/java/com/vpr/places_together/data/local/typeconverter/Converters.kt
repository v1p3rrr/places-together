package com.vpr.places_together.data.local.typeconverter

import androidx.room.TypeConverter
import com.vpr.places_together.utils.enums.FriendshipStatus
import com.vpr.places_together.utils.enums.GroupMemberRole
import com.vpr.places_together.utils.enums.MarkPlaceStatus
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class LocalDateTimeConverter {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    @TypeConverter
    fun fromLocalDateTime(dateTime: LocalDateTime?): String? {
        return dateTime?.format(formatter)
    }

    @TypeConverter
    fun toLocalDateTime(dateTimeString: String?): LocalDateTime? {
        return dateTimeString?.let { LocalDateTime.parse(it, formatter) }
    }
}

class FriendshipStatusTypeConverter {

    @TypeConverter
    fun fromEnum(enumValue: FriendshipStatus): String {
        return enumValue.name
    }

    @TypeConverter
    fun toEnum(enumName: String): FriendshipStatus {
        return enumValueOf(enumName)
    }
}

class GroupMemberRoleTypeConverter {

    @TypeConverter
    fun fromEnum(enumValue: GroupMemberRole): String {
        return enumValue.name
    }

    @TypeConverter
    fun toEnum(enumName: String): GroupMemberRole {
        return enumValueOf(enumName)
    }
}

class MarkPlaceStatusTypeConverter {

    @TypeConverter
    fun fromEnum(enumValue: MarkPlaceStatus): String {
        return enumValue.name
    }

    @TypeConverter
    fun toEnum(enumName: String): MarkPlaceStatus {
        return enumValueOf(enumName)
    }
}