package com.example.moviesclone.feature_home.data.local

import androidx.room.*

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie WHERE id = :id")
    suspend fun getMovieById(id: String): MovieEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieEntity)

    @Update
    suspend fun updateMovie(movie: MovieEntity)

    @Query("SELECT * FROM movie")
    suspend fun getAllMovies(): List<MovieEntity>

    @Query("DELETE FROM movie where id = :id")
    suspend fun deleteMovieById(id: String)

}