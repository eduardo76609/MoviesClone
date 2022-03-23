package com.example.moviesclone.feature_movie_details.data.remote

import com.example.moviesclone.core.di.API_KEY
import com.example.moviesclone.core.di.ID
import com.example.moviesclone.feature_movie_details.domain.models.MovieDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailsApi {

    @GET("movie/{id}?")
    suspend fun getMovieDetails(
        @Path(ID) id: String,
        @Query(API_KEY) apiKey: String
    ): Response<MovieDetail>

}