package com.example.testskillcondorlabsjg.listmovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testskillcondorlabsjg.R
import com.example.testskillcondorlabsjg.databinding.ActivityMainBinding

class MovieActivity : AppCompatActivity() {
    var movieBinding: ActivityMainBinding? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = movieBinding?.root
        setContentView(view)
    }

    fun initializeWidgets() {

    }
}