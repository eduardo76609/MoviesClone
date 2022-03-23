package com.example.moviesclone.feature_serie_details.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.moviesclone.R
import com.example.moviesclone.common.SERIE_ID
import com.example.moviesclone.common.URL_DOWNLOAD_IMAGE
import com.example.moviesclone.common.URL_DOWNLOAD_IMAGE_BIG
import com.example.moviesclone.databinding.ActivitySerieDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SerieDetailActivity : AppCompatActivity() {

    companion object {
        fun getIntent(activityContext: Context, serieId: String) =
            Intent(activityContext, SerieDetailActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                putExtra(SERIE_ID, serieId)
            }
    }

    private val serieDetailsViewModel: SerieDetailsViewModel by viewModels()
    private var _binding: ActivitySerieDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var serieId: String

    private val requestOption: RequestOptions =
        RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
            .error(R.drawable.ic_broken_image)
            .placeholder(R.drawable.ic_preview_image)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySerieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObservers()
        loadDataBundle()
        serieDetailsViewModel.getSerieDetails(serieId)
    }

    private fun initObservers() {

        serieDetailsViewModel.progressVisibility.observe(this) { value ->
            Log.i("", "")
        }

        serieDetailsViewModel.serieDetails.observe(this) { serie ->

            Glide.with(this).load("$URL_DOWNLOAD_IMAGE_BIG${serie.backdropPath}")
                .apply(requestOption)
                .centerCrop()
                .into(binding.ImageViewPreviewTransparent)

            Glide.with(this).load("$URL_DOWNLOAD_IMAGE${serie.posterPath}")
                .apply(requestOption)
                .centerCrop()
                .into(binding.imageViewPreview)

            binding.TextViewRate.text = serie.name
            binding.TextViewYear.text = """Seasons: ${serie.numberSeasons}"""
            binding.TextViewDuration.text = "hola"
            binding.RecyclerViewGenres.adapter = GenreAdapter(serie.genres)
            binding.TextViewDescription.text = serie.overview
            binding.RecyclerViewSeasons.adapter = SeasonAdapter(serie.seasons)
        }

    }

    private fun loadDataBundle() {
        serieId = intent.getStringExtra(SERIE_ID).toString()
    }

}