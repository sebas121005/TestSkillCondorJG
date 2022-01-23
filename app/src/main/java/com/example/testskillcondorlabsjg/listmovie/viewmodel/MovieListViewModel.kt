package com.example.testskillcondorlabsjg.listmovie.viewmodel

import androidx.lifecycle.ViewModel
import com.example.testskillcondorlabsjg.MovieRepository

class MovieListViewModel: ViewModel() {
    private val movieRepository = MovieRepository()

    fun getMovies() {
    }
}