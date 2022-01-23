package com.example.testskillcondorlabsjg.listmovie.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testskillcondorlabsjg.BuildConfig
import com.example.testskillcondorlabsjg.databinding.ItemMovieBinding
import com.example.testskillcondorlabsjg.listmovie.model.Movie
import com.example.testskillcondorlabsjg.listmovie.viewmodel.MovieListViewModel
import com.squareup.picasso.Picasso

class MovieListAdapter(private val context: Context, private val dataMovie: List<Movie> ,
                        private val movieListViewModel: MovieListViewModel?):
    RecyclerView.Adapter<MovieListAdapter.ViewHolderMovie>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMovie {
        val itemMovieBinding = ItemMovieBinding.inflate(LayoutInflater.from(context),
            parent, false)

        return ViewHolderMovie(itemMovieBinding)

    }

    override fun onBindViewHolder(holder: ViewHolderMovie, position: Int) {
        holder.addItemMovie(dataMovie[position])
        holder.onClickDetailMovie(dataMovie[position], movieListViewModel)
    }

    override fun getItemCount(): Int {
        return dataMovie.size
    }

    class ViewHolderMovie(private val itemMovieBinding: ItemMovieBinding):
            RecyclerView.ViewHolder(itemMovieBinding.root) {

        fun addItemMovie(movie: Movie) {
            itemMovieBinding.movieName.text = movie.movieName
            itemMovieBinding.averageMovie.text = movie.movieAverage.toString()
            Picasso.get().load("${BuildConfig.URL_IMAGE}${movie.moviePosterPath}")
                .into(itemMovieBinding.posterImage)

        }

        fun onClickDetailMovie(movie: Movie, movieListViewModel: MovieListViewModel?) {
            itemMovieBinding.seeDetail.setOnClickListener {
                movieListViewModel?.showDetailMovieLiveData?.value = movie
            }
        }
    }
}