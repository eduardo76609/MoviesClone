package com.example.moviesclone.feature_home.domain.usecases

import com.example.moviesclone.core.network.RequestResult
import com.example.moviesclone.feature_home.domain.models.MovieList
import com.example.moviesclone.feature_home.domain.repository.HomeRepository
import javax.inject.Inject

class GetMoviesByGenreUseCase @Inject constructor(private val homeRepository: HomeRepository) {

    suspend fun execute(genre: String): RequestResult<MovieList> {
        return homeRepository.getActionMovies(genre)
    }

}