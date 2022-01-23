package com.example.testskillcondorlabsjg.splash.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.testskillcondorlabsjg.R
import com.example.testskillcondorlabsjg.databinding.ActivitySplashMovieBinding
import com.example.testskillcondorlabsjg.listmovie.viewmodel.MovieListViewModel

class SplashMovieActivity : AppCompatActivity() {
    private var mMovieViewModel: MovieListViewModel? = null
    private var mViewBinding: ActivitySplashMovieBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivitySplashMovieBinding.inflate(layoutInflater)
        val view = mViewBinding?.root
        setContentView(view)

        mMovieViewModel = ViewModelProvider(this)[MovieListViewModel::class.java]
    }
}