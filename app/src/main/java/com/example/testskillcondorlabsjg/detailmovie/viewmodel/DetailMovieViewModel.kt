package com.example.testskillcondorlabsjg.detailmovie.viewmodel

import android.annotation.SuppressLint
import android.database.sqlite.SQLiteDatabase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testskillcondorlabsjg.database.SQLiteMovieHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.content.ContentValues
import com.example.testskillcondorlabsjg.listmovie.viewmodel.MovieListViewModel
import org.json.JSONObject
import android.database.Cursor
import com.example.testskillcondorlabsjg.listmovie.model.Movie


class DetailMovieViewModel: ViewModel() {

    var dbMovieHelper: SQLiteMovieHelper? = null
    private val db: SQLiteDatabase? = dbMovieHelper?.writableDatabase

    companion object {
        const val COLUMN_DATA = "data"
        const val COLUMN_FAVORITE = "favorite"
        const val TABLE_MOVIE = "datamovies"
    }

    fun insertDataMovie(overview: String?, dateRelease: String?, budget: String?,
                        id: String?, isFavorite: Boolean?) {

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val dataJson = JSONObject()
                dataJson.put(MovieListViewModel.OVERVIEW_MOVIE, overview)
                dataJson.put(MovieListViewModel.RELEASE_MOVIE, dateRelease)
                dataJson.put(MovieListViewModel.BUDGET_MOVIE, budget)

                val contentValues = ContentValues()
                contentValues.put(MovieListViewModel.ID_MOVIE, id)
                contentValues.put(COLUMN_DATA, dataJson.toString())
                contentValues.put(COLUMN_FAVORITE, if (isFavorite!!) 1 else 0)
                db?.insert(TABLE_MOVIE, null, contentValues)
                db?.close()
            }
        }
    }

    @SuppressLint("Range")
    fun getDataDetailMovie(): Movie {
        val movieData = Movie()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val cursor: Cursor? = db?.rawQuery(
                    "SELECT ${MovieListViewModel.ID_MOVIE}, $COLUMN_FAVORITE FROM $TABLE_MOVIE",
                    null
                )
                var movieId: String? = null
                var movieFavorite: String? = null

                if (cursor != null) {
                    cursor.moveToFirst()
                    do {
                        movieId =
                            cursor.getString(cursor.getColumnIndex(MovieListViewModel.ID_MOVIE))
                        movieFavorite = cursor.getString(cursor.getColumnIndex(COLUMN_FAVORITE))
                    } while (cursor.moveToNext())
                }
                cursor?.close()
                db?.close()

                movieData.movieId = movieId?.toInt()
                movieData.movieFavorite = movieFavorite.equals("1")
            }

        }

        return movieData
    }

    fun updateFavoriteMovie(isFavorite: Int?) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val contentValues = ContentValues()
                db?.update(TABLE_MOVIE, contentValues, "$COLUMN_FAVORITE='$isFavorite'",
                    null)
                db?.close()
            }
        }
    }
}