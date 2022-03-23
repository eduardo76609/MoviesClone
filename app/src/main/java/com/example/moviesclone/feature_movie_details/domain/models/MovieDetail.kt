package com.example.moviesclone.feature_movie_details.domain.models

import com.google.gson.annotations.SerializedName

data class MovieDetail(
    val genres: List<Genre>,
    val id: Int,
    val name: String,
    val overview: String,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("release_date") val releaseDate: String,
    val runtime: Int,
    @SerializedName("vote_average") val voteAverage: Double,
)