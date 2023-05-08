package com.vpr.places_together.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vpr.places_together.data.local.entity.GroupEntity

@Dao
interface GroupDao {
    @Insert
    suspend fun insert(group: GroupEntity)

    @Query("SELECT * FROM groups WHERE groupId = :id")
    suspend fun getById(id: Long): GroupEntity?

    @Query("SELECT * FROM groups WHERE name LIKE '%' || :name || '%'")
    suspend fun searchByName(name: String): List<GroupEntity>
}
