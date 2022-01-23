package com.example.testskillcondorlabsjg.listmovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testskillcondorlabsjg.databinding.ActivityMainBinding
import com.example.testskillcondorlabsjg.listmovie.model.Movie
import com.example.testskillcondorlabsjg.listmovie.view.adapter.MovieListAdapter
import com.example.testskillcondorlabsjg.listmovie.viewmodel.MovieListViewModel

class MovieActivity : AppCompatActivity() {
    private var mMovieBinding: ActivityMainBinding? = null
    private var mMovieListAdapter: MovieListAdapter? = null
    private var mMovieViewModel: MovieListViewModel? = null

    private var dataMovieList = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMovieBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mMovieBinding?.root
        setContentView(view)
        initializeWidgets()
        observables()
    }

    private fun initializeWidgets() {
        mMovieViewModel = ViewModelProvider(this)[MovieListViewModel::class.java]
        mMovieListAdapter = MovieListAdapter(this, dataMovieList)
        with(mMovieBinding?.listMovies) {
            this?.layoutManager = LinearLayoutManager(this@MovieActivity)
            this?.adapter = mMovieListAdapter
        }
        mMovieViewModel?.getMovies()
    }

    private fun observables() {
        mMovieViewModel?.showListMoviesLiveDate?.observe(this, {
            it.resultsMovie?.let { listMovies ->
                dataMovieList.clear()
                dataMovieList.addAll(listMovies)
                mMovieListAdapter?.notifyDataSetChanged()
            }
        })
    }
}