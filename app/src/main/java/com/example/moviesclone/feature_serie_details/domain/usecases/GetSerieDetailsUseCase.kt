package com.example.moviesclone.feature_serie_details.domain.usecases

import com.example.moviesclone.core.network.RequestResult
import com.example.moviesclone.feature_serie_details.domain.models.SerieDetail
import com.example.moviesclone.feature_serie_details.domain.repository.SerieDetailsRepository
import javax.inject.Inject

class GetSerieDetailsUseCase @Inject constructor(private val serieDetailsRepository: SerieDetailsRepository) {

    suspend fun execute(id: String): RequestResult<SerieDetail> {
        return serieDetailsRepository.getSerieDetails(id)
    }

}