package com.example.testskillcondorlabsjg.detailmovie.viewmodel

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


class DetailMovieViewModel: ViewModel() {

    var dbMovieHelper: SQLiteMovieHelper? = null

    companion object {
        const val COLUMN_DATA = "data"
        const val COLUMN_FAVORITE = "favorite"
        const val TABLE_MOVIE = "favorite"
    }

    fun insertDataMovie(overview: String, dateRelease: String, budget: String,
                        id: String, isFavorite: Boolean) {
        val db: SQLiteDatabase? = dbMovieHelper?.writableDatabase

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val dataJson = JSONObject()
                dataJson.put(MovieListViewModel.OVERVIEW_MOVIE, overview)
                dataJson.put(MovieListViewModel.RELEASE_MOVIE, dateRelease)
                dataJson.put(MovieListViewModel.BUDGET_MOVIE, budget)

                val contentValues = ContentValues()
                contentValues.put(MovieListViewModel.ID_MOVIE, id)
                contentValues.put(COLUMN_DATA, dataJson.toString())
                contentValues.put(COLUMN_FAVORITE, if (isFavorite) 1 else 0)
                db?.insert(TABLE_MOVIE, null, contentValues)
            }
        }
    }
}