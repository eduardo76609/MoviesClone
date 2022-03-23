package com.example.moviesclone.core.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesclone.feature_home.data.local.MovieDao
import com.example.moviesclone.feature_home.data.local.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MoviesCloneDatabase : RoomDatabase() {
     abstract fun movieDao(): MovieDao
}