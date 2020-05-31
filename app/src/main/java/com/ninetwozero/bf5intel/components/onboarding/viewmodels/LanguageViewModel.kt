package com.ninetwozero.bf5intel.components.onboarding.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ninetwozero.bf5intel.repository.SettingsRepository
import com.ninetwozero.bf5intel.repository.storage.BfVDatabase
import com.ninetwozero.bf5intel.repository.storage.entity.Settings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LanguageViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: SettingsRepository
    var settings: Settings

    init {
        val settingsDao = BfVDatabase.getDatabase(application, viewModelScope).settingsDao()
        repository = SettingsRepository(settingsDao)
        settings = repository.getSettings
    }

    fun insert(language: String) = viewModelScope.launch(Dispatchers.IO) {
        settings.language = language
        repository.insert(settings)
    }
}
