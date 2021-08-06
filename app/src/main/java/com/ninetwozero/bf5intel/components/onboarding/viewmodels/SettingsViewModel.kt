package com.ninetwozero.bf5intel.components.onboarding.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ninetwozero.bf5intel.repository.SettingsRepository
import com.ninetwozero.bf5intel.data.entity.Settings
import kotlinx.coroutines.launch

class SettingsViewModel(private val settingsRepository: SettingsRepository) : ViewModel() {

   /* val settings: LiveData<Settings> = settingsRepository.getSettings.asLiveData() */

    fun insert(settings: Settings) = viewModelScope.launch {
        settingsRepository.insert(settings)
    }
}

class SettingsViewModelFactory(private val repository: SettingsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SettingsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SettingsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
