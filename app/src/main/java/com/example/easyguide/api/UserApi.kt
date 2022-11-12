package com.example.easyguide.api

import com.example.easyguide.models.SignInRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("/user/signIn")
    suspend fun <T : Any?> signIn(@Body userRequest: SignInRequest): Response<T>

    @POST("/user/signup")
    suspend fun <T : Any?> signUp(@Body userRequest: SignInRequest): Response<T>
}