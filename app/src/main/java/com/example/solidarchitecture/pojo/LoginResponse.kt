package com.example.solidarchitecture.pojo

import com.google.gson.annotations.SerializedName

data class LoginResponse( @SerializedName("token") val token : String)