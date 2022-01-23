package com.example.testskillcondorlabsjg

import com.example.testskillcondorlabsjg.api.ApiCallbackHelper
import com.example.testskillcondorlabsjg.api.RetrofitManager
import com.example.testskillcondorlabsjg.api.WebService
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
                response.body()?.let { callbackHelper.onSuccess(it) }
            }

            override fun onFailure(call: Call<ResultMovie>, t: Throwable) {
                callbackHelper.onFailure()
            }

        })
    }
}