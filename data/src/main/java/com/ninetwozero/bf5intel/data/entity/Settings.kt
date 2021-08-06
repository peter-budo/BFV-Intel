package com.ninetwozero.bf5intel.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "settings_table")
data class Settings(
    @PrimaryKey @ColumnInfo(name = "position") val position: Int,
    @ColumnInfo(name = "language") var language: String,
    @ColumnInfo(name = "analytics_permission") val analyticsPermission: Boolean,
    @ColumnInfo(name = "selected_soldier") val selectedSoldier: String
)