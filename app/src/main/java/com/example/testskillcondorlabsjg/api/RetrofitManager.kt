package com.example.testskillcondorlabsjg.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class RetrofitManager {
    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val gson = GsonBuilder()
        .setLenient()
        .create()

}