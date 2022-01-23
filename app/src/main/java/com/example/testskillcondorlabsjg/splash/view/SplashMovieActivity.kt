package com.example.testskillcondorlabsjg.splash.view

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import com.example.testskillcondorlabsjg.databinding.ActivitySplashMovieBinding
import com.example.testskillcondorlabsjg.listmovie.view.MovieActivity

class SplashMovieActivity : AppCompatActivity() {
    private var mViewBinding: ActivitySplashMovieBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivitySplashMovieBinding.inflate(layoutInflater)
        val view = mViewBinding?.root
        setContentView(view)

        SystemClock.sleep(2000);

        startActivity(Intent(this, MovieActivity::class.java))

    }
}