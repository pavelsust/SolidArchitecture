package com.example.solidarchitecture.data.api

import com.example.solidarchitecture.domain.entities.LoginResponse
import com.google.gson.JsonObject
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiPostInterface {

    @Headers("Content-Type: application/json")
    @POST("/auth/token")
    fun getLoginCall(@Body bean: JsonObject): Single<LoginResponse>

}