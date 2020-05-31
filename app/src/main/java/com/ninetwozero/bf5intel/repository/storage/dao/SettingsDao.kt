package com.ninetwozero.bf5intel.repository.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ninetwozero.bf5intel.repository.storage.entity.Settings

@Dao
interface SettingsDao {

    @Query("SELECT * FROM settings_table WHERE position = 1")
    fun getSettings(): Settings

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(settings: Settings)
}