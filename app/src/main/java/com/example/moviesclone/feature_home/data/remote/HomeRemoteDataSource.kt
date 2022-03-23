package com.example.moviesclone.feature_home.data.remote

import com.example.moviesclone.core.network.ManageRequest
import com.example.moviesclone.core.network.RequestResult
import com.example.moviesclone.feature_home.domain.models.MovieList
import javax.inject.Inject

class HomeRemoteDataSource @Inject constructor(private val homeApi: HomeApi) : ManageRequest() {

    suspend fun getMoviesByGenre(api_key: String, page: String, genre: String) : RequestResult<MovieList> {
        return safeApiCall { homeApi.getMoviesByGenre(api_key, page, genre) }
    }

    suspend fun getSeriesByGenre(api_key: String, page: String, genre: String) : RequestResult<MovieList> {
        return safeApiCall { homeApi.getSeriesByGenre(api_key, page, genre) }
    }

}