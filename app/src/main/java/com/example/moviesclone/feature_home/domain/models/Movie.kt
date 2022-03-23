package com.example.moviesclone.feature_home.domain.models

import com.google.gson.annotations.SerializedName

data class Movie(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path") val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val voteCount: Int
)