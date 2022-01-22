package com.example.testskillcondorlabsjg.listmovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testskillcondorlabsjg.R
import com.example.testskillcondorlabsjg.databinding.ActivityMainBinding
import com.example.testskillcondorlabsjg.listmovie.view.adapter.MovieListAdapter

class MovieActivity : AppCompatActivity() {
    private var movieBinding: ActivityMainBinding? = null
    private var movieListAdapter: MovieListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = movieBinding?.root
        setContentView(view)
        initializeWidgets()
    }

    fun initializeWidgets() {
        movieListAdapter = MovieListAdapter(this, ArrayList())

        with(movieBinding?.listMovies) {
            this?.layoutManager = LinearLayoutManager(this@MovieActivity)
            this?.adapter = movieListAdapter
        }
    }
}