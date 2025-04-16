package com.example.th_tuan_7.ui.theme

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.th_tuan_7.ui.theme.screens.AppTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "theme_prefs")

class ThemePreferenceManager(private val context: Context) {
    companion object {
        val THEME_KEY = stringPreferencesKey("app_theme")
    }

    val getTheme: Flow<AppTheme?> = context.dataStore.data.map { prefs ->
        prefs[THEME_KEY]?.let { AppTheme.valueOf(it) }
    }

    suspend fun saveTheme(theme: AppTheme) {
        context.dataStore.edit { prefs ->
            prefs[THEME_KEY] = theme.name
        }
    }
}
