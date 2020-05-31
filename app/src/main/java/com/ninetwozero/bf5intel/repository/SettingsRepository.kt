package com.ninetwozero.bf5intel.repository

import com.ninetwozero.bf5intel.repository.storage.dao.SettingsDao
import com.ninetwozero.bf5intel.repository.storage.entity.Settings

class SettingsRepository(private val settingsDao: SettingsDao) {

    val getSettings: Settings = settingsDao.getSettings()

    suspend fun insert(settings: Settings) {
        settingsDao.insert(settings)
    }
}