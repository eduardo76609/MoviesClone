package com.example.moviesclone.feature_movie_details.data

import com.example.moviesclone.core.network.RequestResult
import com.example.moviesclone.feature_movie_details.data.remote.MovieDetailsRemoteDataSource
import com.example.moviesclone.feature_movie_details.domain.models.MovieDetail
import com.example.moviesclone.feature_movie_details.domain.repository.MovieDetailsRepository
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(
    private val movieDetailsRemoteDataSource: MovieDetailsRemoteDataSource
) : MovieDetailsRepository {

    override suspend fun getMovieDetails(id: String): RequestResult<MovieDetail> {
        return movieDetailsRemoteDataSource.getMovieDetails("0093b443517503cc33ee2e181513a5a3", id)
    }

}