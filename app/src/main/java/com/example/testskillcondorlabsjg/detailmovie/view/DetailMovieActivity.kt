package com.example.testskillcondorlabsjg.detailmovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testskillcondorlabsjg.R
import com.example.testskillcondorlabsjg.databinding.ActivityDetailMovieBinding
import com.example.testskillcondorlabsjg.listmovie.viewmodel.MovieListViewModel
import android.view.MenuItem
import android.widget.CompoundButton
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.testskillcondorlabsjg.database.SQLiteMovieHelper
import com.example.testskillcondorlabsjg.detailmovie.viewmodel.DetailMovieViewModel


class DetailMovieActivity : AppCompatActivity() {
    private var mDetailMovieBinding: ActivityDetailMovieBinding? = null
    private var mDetailMovieViewModel: DetailMovieViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        val view = mDetailMovieBinding?.root
        setContentView(view)

        initializeWidget()
    }

    private fun initializeWidget() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detalle Pelicula"
        mDetailMovieViewModel = ViewModelProvider(this)[DetailMovieViewModel::class.java]
        mDetailMovieViewModel?.dbMovieHelper = SQLiteMovieHelper(this)


        showDetailMovie()
    }

    private fun setChangeToggleFavorite(isFavorite: Boolean) {
        if (isFavorite) {
            mDetailMovieBinding?.isFavoriteToggle?.background = ContextCompat.getDrawable(
                this, R.drawable.star_enabled)
        } else {
            mDetailMovieBinding?.isFavoriteToggle?.background = ContextCompat.getDrawable(
                this, R.drawable.star_disabled)
        }


        mDetailMovieBinding?.isFavoriteToggle?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                mDetailMovieViewModel?.updateFavoriteMovie(1)
                mDetailMovieBinding?.isFavoriteToggle?.background = ContextCompat.getDrawable(
                    applicationContext, R.drawable.star_enabled)
            } else {
                mDetailMovieViewModel?.updateFavoriteMovie(0)
                mDetailMovieBinding?.isFavoriteToggle?.background = ContextCompat.getDrawable(
                    applicationContext, R.drawable.star_disabled)
            }
        }
    }

    private fun showDetailMovie() {
        mDetailMovieBinding?.overviewMovie?.text = intent.extras?.getString(MovieListViewModel.OVERVIEW_MOVIE)
        mDetailMovieBinding?.dateReleaseMovie?.text = intent.extras?.getString(MovieListViewModel.RELEASE_MOVIE)
        mDetailMovieBinding?.budgetMovie?.text = intent.extras?.getString(MovieListViewModel.BUDGET_MOVIE)
        intent.extras?.getBoolean(MovieListViewModel.TRAILER_MOVIE)

        val movieDataTable = mDetailMovieViewModel?.getDataDetailMovie()

        if (movieDataTable?.movieId != null) {
            movieDataTable.movieFavorite?.let { setChangeToggleFavorite(it) }

        } else {
            mDetailMovieViewModel?.insertDataMovie(intent.extras?.getString(MovieListViewModel.OVERVIEW_MOVIE),
                intent.extras?.getString(MovieListViewModel.RELEASE_MOVIE),
                intent.extras?.getString(MovieListViewModel.BUDGET_MOVIE),
                intent.extras?.getString(MovieListViewModel.ID_MOVIE), false)

            setChangeToggleFavorite(false)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}