package com.example.solidarchitecture.domain.entities

import com.google.gson.annotations.SerializedName

data class LoginResponse( @SerializedName("token") val token : String)