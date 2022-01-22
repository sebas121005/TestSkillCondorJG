package com.example.testskillcondorlabsjg.listmovie.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testskillcondorlabsjg.R
import com.example.testskillcondorlabsjg.listmovie.model.Movie

class MovieListAdapter(private val context: Context, val dataMovie: List<Movie>): RecyclerView.Adapter<MovieListAdapter.ViewHolderMovie>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMovie {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)

        return ViewHolderMovie(view)

    }

    override fun onBindViewHolder(holder: ViewHolderMovie, position: Int) {
        holder.addItemMovie(dataMovie[position])
    }

    override fun getItemCount(): Int {
        return dataMovie.size
    }

    class ViewHolderMovie(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var mPosterImageview: ImageView? = null
        private var mNameMovieTextView: TextView? = null
        var mAverageTextView: TextView? = null
        init {
            mPosterImageview = itemView.findViewById(R.id.poster_image)
            mNameMovieTextView = itemView.findViewById(R.id.movie_name)
            mAverageTextView = itemView.findViewById(R.id.average_movie)
        }

        fun addItemMovie(movie: Movie) {
            mNameMovieTextView?.text = movie.movieName
            mAverageTextView?.text = movie.movieAverage.toString()
        }
    }
}