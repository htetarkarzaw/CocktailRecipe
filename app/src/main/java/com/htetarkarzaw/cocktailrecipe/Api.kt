package com.example.myapplication

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api {
    @Headers("Content-Type: application/xml")
    @POST("arttha")
    fun getTest(@Body body: RequestBody): Call<Response>
}