package com.example.moviesclone.core.di

import com.example.moviesclone.feature_home.data.HomeRepositoryImpl
import com.example.moviesclone.feature_home.data.remote.HomeRemoteDataSource
import com.example.moviesclone.feature_home.domain.repository.HomeRepository
import com.example.moviesclone.feature_home.domain.usecases.GetMoviesByGenreUseCase
import com.example.moviesclone.feature_home.domain.usecases.GetSeriesByGenreUseCase
import com.example.moviesclone.feature_movie_details.data.MovieDetailsRepositoryImpl
import com.example.moviesclone.feature_movie_details.data.remote.MovieDetailsRemoteDataSource
import com.example.moviesclone.feature_movie_details.domain.repository.MovieDetailsRepository
import com.example.moviesclone.feature_serie_details.data.SerieDetailsRepositoryImpl
import com.example.moviesclone.feature_serie_details.data.remote.SerieDetailsRemoteDataSource
import com.example.moviesclone.feature_serie_details.domain.repository.SerieDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object CleanModule {

    @Provides
    fun bindHomeRepository(
        homeRemoteDataSource: HomeRemoteDataSource
    ): HomeRepository = HomeRepositoryImpl(homeRemoteDataSource)

    @Provides
    fun provideGetMoviesByGenreUseCase(homeRepository: HomeRepository) =
        GetMoviesByGenreUseCase(homeRepository)

    @Provides
    fun provideSeriesByGenreUseCase(homeRepository: HomeRepository) =
        GetSeriesByGenreUseCase(homeRepository)

    @Provides
    fun bindMovieDetailRepository(
        movieDetailsRemoteUseCase: MovieDetailsRemoteDataSource
    ): MovieDetailsRepository = MovieDetailsRepositoryImpl(movieDetailsRemoteUseCase)

    @Provides
    fun bindSerieDetailsRepository(
        serieDetailsRemoteUseCase: SerieDetailsRemoteDataSource
    ): SerieDetailsRepository = SerieDetailsRepositoryImpl(serieDetailsRemoteUseCase)


}