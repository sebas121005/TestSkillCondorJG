package com.example.testskillcondorlabsjg

import com.example.testskillcondorlabsjg.api.RetrofitManager
import com.example.testskillcondorlabsjg.api.WebService
import com.example.testskillcondorlabsjg.listmovie.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository {
    private var webService: WebService? = null

    init {
        webService = RetrofitManager().createWebService("")
    }

    fun getMovies() {
        webService?.getMovies("")?.enqueue(object: Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}