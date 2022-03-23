package com.example.moviesclone.feature_home.data

import com.example.moviesclone.core.network.RequestResult
import com.example.moviesclone.feature_home.data.remote.HomeRemoteDataSource
import com.example.moviesclone.feature_home.domain.models.MovieList
import com.example.moviesclone.feature_home.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeRemoteDataSource: HomeRemoteDataSource
) : HomeRepository {

    override suspend fun getActionMovies(genre: String): RequestResult<MovieList> {
        return homeRemoteDataSource.getMoviesByGenre("0093b443517503cc33ee2e181513a5a3", "1", genre)
    }

    override suspend fun getActionSeries(genre: String): RequestResult<MovieList> {
        return homeRemoteDataSource.getSeriesByGenre("0093b443517503cc33ee2e181513a5a3", "1", genre)
    }

}