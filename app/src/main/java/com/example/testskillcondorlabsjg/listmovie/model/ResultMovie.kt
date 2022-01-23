package com.example.testskillcondorlabsjg.listmovie.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultMovie {
    @SerializedName("results")
    @Expose
    var resultsMovie: List<Movie>? = null
}