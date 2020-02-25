package com.example.simpleretrofit

import android.telecom.Call
import retrofit2.http.GET

interface GetDataService {

    @GET("/photos?albumId=1")
    fun getAllPhotos(): retrofit2.Call<List<PhotoData>>

}