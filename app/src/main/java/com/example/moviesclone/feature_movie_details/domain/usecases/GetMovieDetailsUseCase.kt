package com.example.moviesclone.feature_movie_details.domain.usecases

import com.example.moviesclone.core.network.RequestResult
import com.example.moviesclone.feature_movie_details.domain.models.MovieDetail
import com.example.moviesclone.feature_movie_details.domain.repository.MovieDetailsRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val movieDetailsRepository: MovieDetailsRepository) {

    suspend fun execute(id: String): RequestResult<MovieDetail> {
        return movieDetailsRepository.getMovieDetails(id)
    }

}