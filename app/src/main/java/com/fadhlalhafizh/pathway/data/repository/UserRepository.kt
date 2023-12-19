package com.fadhlalhafizh.pathway.data.repository

import com.fadhlalhafizh.pathway.data.model.UserModel
import com.fadhlalhafizh.pathway.data.preferences.UserPreference
import com.fadhlalhafizh.pathway.data.remote.response.LoginResponse
import com.fadhlalhafizh.pathway.data.remote.response.RegisterResponse
import com.fadhlalhafizh.pathway.data.remote.retrofit.ApiService
import kotlinx.coroutines.flow.Flow

class UserRepository private constructor(
    private val userPreference: UserPreference,
    private val apiService: ApiService,
) {

    suspend fun saveSession(user: UserModel) {
        userPreference.saveSession(user)
    }

    fun getSession(): Flow<UserModel> {
        return userPreference.getUserSession()
    }

    suspend fun logout() {
        userPreference.clearToken()
    }

    suspend fun signupUser(name: String, email: String, password: String): RegisterResponse {
        return apiService.signup(name, email, password)
    }

    suspend fun signInUser(email: String, password: String): LoginResponse {
        return apiService.login(email, password)
    }

    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            userPreference: UserPreference,
            apiService: ApiService,
        ): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(userPreference, apiService)
            }.also { instance = it }
    }
}