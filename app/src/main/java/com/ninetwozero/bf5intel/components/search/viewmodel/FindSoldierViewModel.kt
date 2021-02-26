package com.ninetwozero.bf5intel.components.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FindSoldierViewModel: ViewModel() {

    fun findSoldier(platform: String, userLocale: String, playerName: String) = viewModelScope.launch {

    }
}

class FindSoldierViewModelFactory(): ViewModelProvider.Factory {
    override fun <T: ViewModel?> create(modelClass: Class<T>): T {
        if( modelClass.isAssignableFrom(FindSoldierViewModel::class.java)) {
            return FindSoldierViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}