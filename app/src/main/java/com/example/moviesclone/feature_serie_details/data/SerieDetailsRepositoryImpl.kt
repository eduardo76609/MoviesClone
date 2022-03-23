package com.example.moviesclone.feature_serie_details.data

import com.example.moviesclone.core.network.RequestResult
import com.example.moviesclone.feature_serie_details.data.remote.SerieDetailsRemoteDataSource
import com.example.moviesclone.feature_serie_details.domain.models.SerieDetail
import com.example.moviesclone.feature_serie_details.domain.repository.SerieDetailsRepository
import javax.inject.Inject

class SerieDetailsRepositoryImpl @Inject constructor(
    private val serieDetailsRemoteDataSource: SerieDetailsRemoteDataSource
) : SerieDetailsRepository {

    override suspend fun getSerieDetails(id: String): RequestResult<SerieDetail> {
        return serieDetailsRemoteDataSource.getSerieDetails("0093b443517503cc33ee2e181513a5a3", id)
    }

}