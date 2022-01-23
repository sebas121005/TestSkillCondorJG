package com.example.testskillcondorlabsjg.listmovie.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Movie {
    @SerializedName("title")
    @Expose
    var movieName: String? = null

    @SerializedName("poster_path")
    @Expose
    var moviePosterPath: String? = null

    @SerializedName("vote_average")
    @Expose
    var movieAverage: Double? = null

    @SerializedName("overview")
    @Expose
    var movieOverview: String? = null

    @SerializedName("release_date")
    @Expose
    var movieReleaseDate: String? = null

    @SerializedName("popularity")
    @Expose
    var movieBudget: String? = null

    @SerializedName("video")
    @Expose
    var movieTrailer: Boolean? = null

}