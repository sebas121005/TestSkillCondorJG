package com.example.testskillcondorlabsjg.listmovie.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testskillcondorlabsjg.MovieRepository
import com.example.testskillcondorlabsjg.api.ApiCallbackHelper
import com.example.testskillcondorlabsjg.listmovie.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListViewModel: ViewModel() {
    private val movieRepository = MovieRepository()
    val showListMoviesLiveDate = MutableLiveData<Movie>()

    fun getMovies() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                movieRepository.getMovies(object : ApiCallbackHelper<Movie> {
                    override fun onSuccess(response: Movie) {
                        showListMoviesLiveDate.value = response
                    }

                    override fun onFailure() {
                        TODO("Not yet implemented")
                    }

                })
            }
        }
    }
}