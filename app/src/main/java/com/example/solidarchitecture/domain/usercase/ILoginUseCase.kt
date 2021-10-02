package com.example.solidarchitecture.domain.usercase

import com.example.solidarchitecture.pojo.LoginResponse
import com.example.solidarchitecture.repository.ILoginRepository
import com.google.gson.JsonObject
import io.reactivex.rxjava3.core.Single

interface ILoginUseCase {
    var iLoginRepository : ILoginRepository
    fun userLogin(jsonObject: JsonObject) : Single<LoginResponse>

}