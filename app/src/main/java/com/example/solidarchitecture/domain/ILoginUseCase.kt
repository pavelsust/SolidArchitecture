package com.example.solidarchitecture.domain

import com.example.solidarchitecture.domain.entities.LoginResponse
import com.example.solidarchitecture.domain.repository.ILoginRepository
import com.google.gson.JsonObject
import io.reactivex.rxjava3.core.Single

interface ILoginUseCase {
    var iLoginRepository : ILoginRepository
    fun userLogin(jsonObject: JsonObject) : Single<LoginResponse>

}