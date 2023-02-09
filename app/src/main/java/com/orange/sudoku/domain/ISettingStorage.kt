package com.orange.sudoku.domain

interface ISettingStorage {
    suspend fun getSettings():SettingsStorageResult
    suspend fun updateSettings():SettingsStorageResult

}

sealed class SettingsStorageResult{
    data class OnSuccess(val settings:Settings):SettingsStorageResult()
    data class OnError(val exception: Exception):SettingsStorageResult()

}