package com.example.testskillcondorlabsjg.api

import com.example.testskillcondorlabsjg.listmovie.model.ResultMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("movie/popular")
    fun getMovies(@Query("api_key") apiKey: String): Call<ResultMovie>
}