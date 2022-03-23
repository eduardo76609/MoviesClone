package com.example.moviesclone.feature_movie_details.presentation

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.moviesclone.R
import com.example.moviesclone.common.MOVIE_ID
import com.example.moviesclone.common.URL_DOWNLOAD_IMAGE
import com.example.moviesclone.common.URL_DOWNLOAD_IMAGE_BIG
import com.example.moviesclone.databinding.ActivityMovieDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate

@AndroidEntryPoint
class MovieDetailActivity : AppCompatActivity() {

    companion object {
        fun getIntent(activityContext: Context, movieId: String) =
            Intent(activityContext, MovieDetailActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                putExtra(MOVIE_ID, movieId)
            }
    }

    private val movieDetailsViewModel: MovieDetailsViewModel by viewModels()
    private var _binding: ActivityMovieDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var movieId: String

    private val requestOption: RequestOptions =
        RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
            .error(R.drawable.ic_broken_image)
            .placeholder(R.drawable.ic_preview_image)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObservers()
        loadDataBundle()
        movieDetailsViewModel.getMovieDetails(movieId)
    }

    private fun initObservers() {

        movieDetailsViewModel.progressVisibility.observe(this) { value ->
            Log.i("", "")
        }

        movieDetailsViewModel.movieDetails.observe(this) { movie ->

            Glide.with(this).load("$URL_DOWNLOAD_IMAGE_BIG${movie.backdropPath}")
                .apply(requestOption)
                .centerCrop()
                .into(binding.ImageViewPreviewTransparent)

            Glide.with(this).load("$URL_DOWNLOAD_IMAGE${movie.posterPath}")
                .apply(requestOption)
                .centerCrop()
                .into(binding.imageViewPreview)

            binding.TextViewRate.text = """${movie.voteAverage}/10"""
            binding.TextViewYear.text = movie.releaseDate.subSequence(0, 4)
            binding.TextViewDuration.text = """${movie.runtime} Minutes"""
            binding.RecyclerViewGenres.adapter = GenreAdapter(movie.genres)
            binding.TextViewDescription.text = movie.overview
        }

    }

    private fun loadDataBundle() {
        movieId = intent.getStringExtra(MOVIE_ID).toString()
    }

}