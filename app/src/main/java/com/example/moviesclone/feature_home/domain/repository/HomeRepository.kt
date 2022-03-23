package com.example.moviesclone.feature_home.domain.repository

import com.example.moviesclone.core.network.RequestResult
import com.example.moviesclone.feature_home.domain.models.MovieList

interface HomeRepository {
    suspend fun getActionMovies(genre: String): RequestResult<MovieList>
    suspend fun getActionSeries(genre: String): RequestResult<MovieList>
}