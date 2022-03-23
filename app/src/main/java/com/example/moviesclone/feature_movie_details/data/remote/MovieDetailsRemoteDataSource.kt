package com.example.moviesclone.feature_movie_details.data.remote

import com.example.moviesclone.core.network.ManageRequest
import com.example.moviesclone.core.network.RequestResult
import com.example.moviesclone.feature_movie_details.domain.models.MovieDetail
import javax.inject.Inject

class MovieDetailsRemoteDataSource @Inject constructor(private val movieDetailsApi: MovieDetailsApi) :
    ManageRequest() {

    suspend fun getMovieDetails(api_key: String, id: String): RequestResult<MovieDetail> {
        return safeApiCall { movieDetailsApi.getMovieDetails(id, api_key) }
    }

}