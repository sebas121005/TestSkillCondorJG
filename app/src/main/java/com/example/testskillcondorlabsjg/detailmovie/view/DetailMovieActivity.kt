package com.example.testskillcondorlabsjg.detailmovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testskillcondorlabsjg.R
import com.example.testskillcondorlabsjg.databinding.ActivityDetailMovieBinding
import com.example.testskillcondorlabsjg.listmovie.viewmodel.MovieListViewModel

class DetailMovieActivity : AppCompatActivity() {
    private var mDetailMovieBinding: ActivityDetailMovieBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        val view = mDetailMovieBinding?.root
        setContentView(view)

        showDetailMovie()
    }

    private fun showDetailMovie() {
        mDetailMovieBinding?.overviewMovie?.text = intent.extras?.getString(MovieListViewModel.OVERVIEW_MOVIE)
        mDetailMovieBinding?.dateReleaseMovie?.text = intent.extras?.getString(MovieListViewModel.RELEASE_MOVIE)
        mDetailMovieBinding?.budgetMovie?.text = intent.extras?.getString(MovieListViewModel.BUDGET_MOVIE)
        mDetailMovieBinding?.budgetMovie?.text = intent.extras?.getString(MovieListViewModel.BUDGET_MOVIE)
        intent.extras?.getBoolean(MovieListViewModel.TRAILER_MOVIE)
    }
}