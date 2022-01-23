package com.example.testskillcondorlabsjg.api

interface ApiCallbackHelper<T> {
    fun onSuccess(response: T)
    fun onFailure()
}