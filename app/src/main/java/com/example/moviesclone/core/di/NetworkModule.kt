package com.example.moviesclone.core.di

import com.example.moviesclone.feature_home.data.remote.HomeApi
import com.example.moviesclone.feature_home.data.remote.HomeRemoteDataSource
import com.example.moviesclone.feature_movie_details.data.remote.MovieDetailsApi
import com.example.moviesclone.feature_movie_details.data.remote.MovieDetailsRemoteDataSource
import com.example.moviesclone.feature_serie_details.data.remote.SerieDetailsApi
import com.example.moviesclone.feature_serie_details.data.remote.SerieDetailsRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://api.themoviedb.org/3/"

const val API_KEY = "api_key"
const val PAGE = "page"
const val WITH_GENRES = "with_genres"
const val ID = "id"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideHomeApi(retrofit: Retrofit): HomeApi = retrofit.create(HomeApi::class.java)

    @Provides
    fun provideHomeRemoteDataSource(homeApi: HomeApi) = HomeRemoteDataSource(homeApi)

    @Provides
    fun provideMovieDetailsApi(retrofit: Retrofit): MovieDetailsApi =
        retrofit.create(MovieDetailsApi::class.java)

    @Provides
    fun provideMovieDetailsRemoteDataSource(movieDetailsApi: MovieDetailsApi) =
        MovieDetailsRemoteDataSource(movieDetailsApi)

    @Provides
    fun provideSerieDetailsApi(retrofit: Retrofit): SerieDetailsApi =
        retrofit.create(SerieDetailsApi::class.java)

    @Provides
    fun provideSerieDetailsRemoteDataSource(serieDetailsApi: SerieDetailsApi) =
        SerieDetailsRemoteDataSource(serieDetailsApi)

}