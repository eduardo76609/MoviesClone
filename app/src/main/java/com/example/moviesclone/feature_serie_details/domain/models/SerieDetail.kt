package com.example.moviesclone.feature_serie_details.domain.models

import com.google.gson.annotations.SerializedName

data class SerieDetail(
	@SerializedName("backdrop_path") val backdropPath : String,
	val genres : List<Genre>,
	val homepage : String,
	val id : Int,
	val name : String,
	val overview : String,
	val popularity : Double,
	@SerializedName("number_of_seasons") val numberSeasons : Int,
	@SerializedName("poster_path") val posterPath : String,
	val seasons : List<Season>,
	@SerializedName("vote_average") val voteAverage : Double,
)