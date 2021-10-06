package com.example.solidarchitecture.domain.repository

import com.example.solidarchitecture.data.api.ApiClientInterface
import com.example.solidarchitecture.domain.entities.LoginResponse
import com.google.gson.JsonObject
import io.reactivex.rxjava3.core.Single

class LoginRepository(override var apiInterface: ApiClientInterface) : ILoginRepository {
    override fun loginUser(jsonObject: JsonObject): Single<LoginResponse> {
        return apiInterface.buildPostApiService().getLoginCall(jsonObject)
    }

}