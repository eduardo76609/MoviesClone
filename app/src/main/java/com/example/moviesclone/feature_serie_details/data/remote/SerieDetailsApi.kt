package com.example.moviesclone.feature_serie_details.data.remote

import com.example.moviesclone.core.di.API_KEY
import com.example.moviesclone.core.di.ID
import com.example.moviesclone.feature_serie_details.domain.models.SerieDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SerieDetailsApi {

    @GET("tv/{id}?")
    suspend fun getSerieDetails(
        @Path(ID) id: String,
        @Query(API_KEY) apiKey: String
    ): Response<SerieDetail>

}