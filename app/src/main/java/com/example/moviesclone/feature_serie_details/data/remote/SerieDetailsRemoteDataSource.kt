package com.example.moviesclone.feature_serie_details.data.remote

import com.example.moviesclone.core.network.ManageRequest
import com.example.moviesclone.core.network.RequestResult
import com.example.moviesclone.feature_serie_details.domain.models.SerieDetail
import javax.inject.Inject

class SerieDetailsRemoteDataSource @Inject constructor(private val serieDetailsApi: SerieDetailsApi) :
    ManageRequest() {

    suspend fun getSerieDetails(api_key: String, id: String): RequestResult<SerieDetail> {
        return safeApiCall { serieDetailsApi.getSerieDetails(id, api_key) }
    }

}