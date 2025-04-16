package com.example.th_tuan_7.ui.theme

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.th_tuan_7.ui.theme.screens.AppTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ThemeViewModel(application: Application) : AndroidViewModel(application) {
    private val prefManager = ThemePreferenceManager(application)

    private val _selectedTheme = MutableStateFlow<AppTheme?>(null)
    val selectedTheme: StateFlow<AppTheme?> = _selectedTheme

    private val _appliedTheme = MutableStateFlow<AppTheme?>(null)
    val appliedTheme: StateFlow<AppTheme?> = _appliedTheme

    init {
        viewModelScope.launch {
            prefManager.getTheme.collect { theme ->
                _appliedTheme.value = theme
            }
        }
    }

    fun selectTheme(theme: AppTheme) {
        _selectedTheme.value = theme
    }

    fun applyTheme() {
        _appliedTheme.value = _selectedTheme.value
        viewModelScope.launch {
            _selectedTheme.value?.let { prefManager.saveTheme(it) }
        }
    }
}
