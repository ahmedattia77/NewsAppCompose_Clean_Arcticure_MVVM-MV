package com.example.newsapp.data.manger

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.newsapp.domain.manger.LocalUserManger
import com.example.newsapp.utils.Constants
import com.example.newsapp.utils.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserMangerImpl(
    private val context: Context
) : LocalUserManger {

    override suspend fun saveAppEntry() {
        context.dataStore.edit { settings ->
            settings[PreferencesKey.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> =
        context.dataStore.data.map { pref ->
            pref[PreferencesKey.APP_ENTRY] ?: false
        }
}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

private object PreferencesKey {
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}