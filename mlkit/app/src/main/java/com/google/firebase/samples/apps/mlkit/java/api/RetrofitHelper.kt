package com.google.firebase.samples.apps.mlkit.com.google.firebase.samples.apps.mlkit.java.api

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

class RetrofitHelper {


    interface RetrofitService {
        @POST("sku")
        fun getItem(@Body body: RequestBody): Call<Array<Model>>
    }

    data class Model(val id: String = "", val description: String = "", val imageUrl: String = "")


    companion object {
        val baseUrl = "http://10.0.7.124:8080/"

        fun buildRetrofit() = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitService::class.java)
    }
}