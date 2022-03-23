package com.example.moviesclone.feature_home.data.remote

import com.example.moviesclone.core.di.API_KEY
import com.example.moviesclone.core.di.PAGE
import com.example.moviesclone.core.di.WITH_GENRES
import com.example.moviesclone.feature_home.domain.models.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApi {

    @GET("discover/movie")
    suspend fun getMoviesByGenre(
        @Query(API_KEY) apiKey: String,
        @Query(PAGE) page: String,
        @Query(WITH_GENRES) withGenres: String
    ) : Response<MovieList>

    @GET("discover/tv")
    suspend fun getSeriesByGenre(
        @Query(API_KEY) apiKey: String,
        @Query(PAGE) page: String,
        @Query(WITH_GENRES) withGenres: String
    ) : Response<MovieList>

}