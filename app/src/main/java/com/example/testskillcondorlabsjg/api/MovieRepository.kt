package com.example.testskillcondorlabsjg.api

import com.example.testskillcondorlabsjg.BuildConfig
import com.example.testskillcondorlabsjg.listmovie.model.ResultMovie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository {
    private var webService: WebService? = null

    init {
        webService = RetrofitManager().createWebService(BuildConfig.URL_SERVER)
    }

    fun getMovies(callbackHelper: ApiCallbackHelper<ResultMovie>) {
        webService?.getMovies(BuildConfig.API_KEY)?.enqueue(object: Callback<ResultMovie> {
            override fun onResponse(call: Call<ResultMovie>, response: Response<ResultMovie>) {
                if (response.isSuccessful) {
                    response.body()?.let { callbackHelper.onSuccess(it) }
                }
            }

            override fun onFailure(call: Call<ResultMovie>, t: Throwable) {
                callbackHelper.onFailure()
            }

        })
    }
}