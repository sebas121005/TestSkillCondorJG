package com.example.testskillcondorlabsjg.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteMovieHelper(context: Context?) : SQLiteOpenHelper(context, NAME_DB, null, 1){
    companion object {
        const val CREATE_BD = "CREATE TABLE movies" +
                "(id INTEGER PRIMARY KEY, data TEXT, favorite INTEGER)"

        const val NAME_DB = "datamovies.sqlite"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_BD)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

}