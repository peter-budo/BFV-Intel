package com.ninetwozero.bf5intel.repository

import com.ninetwozero.bf5intel.data.dao.SettingsDao
import com.ninetwozero.bf5intel.data.entity.Settings
import kotlinx.coroutines.flow.Flow

class SettingsRepository(private val settingsDao: SettingsDao) {

    val getSettings: Flow<Settings> = settingsDao.getSettings()

    suspend fun insert(settings: Settings) {
        settingsDao.insert(settings)
    }
}