package com.example.solidarchitecture.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.solidarchitecture.api.ApiClientInterface
import com.example.solidarchitecture.repository.LoginRepository
import com.example.solidarchitecture.usercase.LoginUseCase

class ViewModelBuilder {

    companion object{

        fun createLoginViewModel(owner: ViewModelStoreOwner): LoginViewModel {
            val apiClient = ApiClientInterface()
            val repository = LoginRepository(apiClient)
            val loginUseCase = LoginUseCase(repository)
            val viewModel = ViewModelProvider(owner).get(LoginViewModel::class.java)
            viewModel.setLoginUseCase(loginUseCase)
            return viewModel
        }

    }
}