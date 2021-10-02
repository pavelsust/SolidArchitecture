package com.example.solidarchitecture.api

import com.example.solidarchitecture.pojo.LoginResponse
import com.google.gson.JsonObject
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiPostInterface {

    @Headers("Content-Type: application/json")
    @POST("/auth/token")
    fun getLoginCall(@Body bean: JsonObject): Single<LoginResponse>

}