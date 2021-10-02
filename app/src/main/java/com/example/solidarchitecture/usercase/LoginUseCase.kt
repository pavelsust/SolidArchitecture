package com.example.solidarchitecture.usercase

import com.example.solidarchitecture.domain.usercase.ILoginUseCase
import com.example.solidarchitecture.pojo.LoginResponse
import com.example.solidarchitecture.repository.ILoginRepository
import com.google.gson.JsonObject
import io.reactivex.rxjava3.core.Single

class LoginUseCase(override var iLoginRepository: ILoginRepository) : ILoginUseCase{

    override fun userLogin(jsonObject: JsonObject): Single<LoginResponse> {
        return iLoginRepository.loginUser(jsonObject)
    }

}