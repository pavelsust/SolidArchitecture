package com.example.solidarchitecture.api

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit


interface ApiClient{
    open fun buildPostApiService(): ApiPostInterface
}




class ApiClientInterface : ApiClient{

    companion object{
        var retrofit: Retrofit?=null

        private fun buildClient() : OkHttpClient{
            return OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS).build()
        }

        fun getClient(): Retrofit{
            if (retrofit==null){
                retrofit = Retrofit.Builder()
                    .client(buildClient())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
            }
            return retrofit!!
        }

    }

    override fun buildPostApiService(): ApiPostInterface {
        return getClient().create(ApiPostInterface::class.java)
    }

}