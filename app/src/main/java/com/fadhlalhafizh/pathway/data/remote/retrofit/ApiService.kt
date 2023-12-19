package com.fadhlalhafizh.pathway.data.remote.retrofit

import com.fadhlalhafizh.pathway.data.remote.response.LoginResponse
import com.fadhlalhafizh.pathway.data.remote.response.RegisterResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("api/users/register")
    suspend fun signup(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): RegisterResponse

    @FormUrlEncoded
    @POST("api/users/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse
}