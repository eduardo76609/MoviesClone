package com.example.moviesclone.feature_movie_details.domain.repository

import com.example.moviesclone.core.network.RequestResult
import com.example.moviesclone.feature_movie_details.domain.models.MovieDetail

interface MovieDetailsRepository {
    suspend fun getMovieDetails(id: String): RequestResult<MovieDetail>
}