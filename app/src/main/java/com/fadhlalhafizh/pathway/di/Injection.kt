package com.fadhlalhafizh.pathway.di

import android.content.Context
import com.fadhlalhafizh.pathway.data.preferences.UserPreference
import com.fadhlalhafizh.pathway.data.preferences.dataStore
import com.fadhlalhafizh.pathway.data.remote.retrofit.ApiConfig
import com.fadhlalhafizh.pathway.data.repository.UserRepository

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        val apiService = ApiConfig.getApiService()
        return UserRepository.getInstance(pref, apiService)
    }
}