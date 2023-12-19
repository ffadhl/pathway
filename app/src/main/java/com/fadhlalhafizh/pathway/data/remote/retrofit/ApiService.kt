package com.fadhlalhafizh.pathway.data.remote.retrofit

import com.fadhlalhafizh.pathway.data.remote.request.LoginRequest
import com.fadhlalhafizh.pathway.data.remote.request.RegistrationRequest
import com.fadhlalhafizh.pathway.data.remote.response.LoginResponse
import com.fadhlalhafizh.pathway.data.remote.response.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("api/users/register")
    suspend fun register(@Body requestBody: RegistrationRequest): RegisterResponse

    @POST("api/users/login")
    suspend fun login(
        @Body requestBody: LoginRequest
    ): LoginResponse
}