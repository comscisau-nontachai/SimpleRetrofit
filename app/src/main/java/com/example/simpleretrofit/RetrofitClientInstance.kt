package com.example.simpleretrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientInstance {

    lateinit var retrofit : Retrofit
    val BASE_URL = "https://jsonplaceholder.typicode.com"

    fun getRetrofitInstance() : Retrofit{
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit
    }
}