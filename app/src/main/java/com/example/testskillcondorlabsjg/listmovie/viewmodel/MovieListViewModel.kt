package com.example.testskillcondorlabsjg.listmovie.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testskillcondorlabsjg.api.MovieRepository
import com.example.testskillcondorlabsjg.api.ApiCallbackHelper
import com.example.testskillcondorlabsjg.listmovie.model.Movie
import com.example.testskillcondorlabsjg.listmovie.model.ResultMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListViewModel: ViewModel() {
    private val movieRepository = MovieRepository()
    val showListMoviesLiveDate = MutableLiveData<ResultMovie>()
    val showDetailMovieLiveData = MutableLiveData<Movie>()

    fun getMovies() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                movieRepository.getMovies(object : ApiCallbackHelper<ResultMovie> {
                    override fun onSuccess(response: ResultMovie) {
                        showListMoviesLiveDate.value = response
                    }

                    override fun onFailure() {
                    }

                })
            }
        }
    }

    companion object {
        const val OVERVIEW_MOVIE = "overview"
        const val RELEASE_MOVIE = "release_date"
        const val BUDGET_MOVIE = "budget"
        const val TRAILER_MOVIE = "trailer"
        const val ID_MOVIE = "id"
    }
}