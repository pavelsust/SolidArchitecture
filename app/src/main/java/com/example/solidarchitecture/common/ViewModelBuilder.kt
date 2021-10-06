package com.example.solidarchitecture.common

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.solidarchitecture.data.api.ApiClientInterface
import com.example.solidarchitecture.domain.repository.LoginRepository
import com.example.solidarchitecture.domain.LoginUseCase
import com.example.solidarchitecture.viewmodel.LoginViewModel

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