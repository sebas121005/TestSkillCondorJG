package com.example.testskillcondorlabsjg.listmovie.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testskillcondorlabsjg.databinding.ItemMovieBinding
import com.example.testskillcondorlabsjg.listmovie.model.Movie

class MovieListAdapter(private val context: Context, private val dataMovie: List<Movie>):
    RecyclerView.Adapter<MovieListAdapter.ViewHolderMovie>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMovie {
        val itemMovieBinding = ItemMovieBinding.inflate(LayoutInflater.from(context),
            parent, false)

        return ViewHolderMovie(itemMovieBinding)

    }

    override fun onBindViewHolder(holder: ViewHolderMovie, position: Int) {
        holder.addItemMovie(dataMovie[position])
    }

    override fun getItemCount(): Int {
        return dataMovie.size
    }

    class ViewHolderMovie(private val itemMovieBinding: ItemMovieBinding):
            RecyclerView.ViewHolder(itemMovieBinding.root) {

        fun addItemMovie(movie: Movie) {
            itemMovieBinding.movieName.text = movie.movieName
            itemMovieBinding.averageMovie.text = movie.movieAverage.toString()
        }
    }
}