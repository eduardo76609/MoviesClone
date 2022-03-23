package com.example.moviesclone.feature_serie_details.domain.repository

import com.example.moviesclone.core.network.RequestResult
import com.example.moviesclone.feature_serie_details.domain.models.SerieDetail

interface SerieDetailsRepository {
    suspend fun getSerieDetails(id: String): RequestResult<SerieDetail>
}