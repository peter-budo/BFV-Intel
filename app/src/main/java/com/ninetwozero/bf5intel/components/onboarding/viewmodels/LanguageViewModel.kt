package com.ninetwozero.bf5intel.components.onboarding.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ninetwozero.bf5intel.repository.SettingsRepository

class LanguageViewModel(private val settingsRepository: SettingsRepository) : ViewModel() {

   /* val settings: LiveData<Settings> = settingsRepository.getSettings.asLiveData()

    fun insert(language: String) = viewModelScope.launch {
        settings.language = language
        settingsRepository.insert(settings)
    }*/
}

class LanguageViewModelFactory(private val repository: SettingsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LanguageViewModel::class.java)) {
            return LanguageViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
