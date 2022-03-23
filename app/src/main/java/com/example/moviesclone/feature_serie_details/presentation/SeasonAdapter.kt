package com.example.moviesclone.feature_serie_details.presentation

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.moviesclone.R
import com.example.moviesclone.common.URL_DOWNLOAD_IMAGE
import com.example.moviesclone.databinding.SeasonCardBinding
import com.example.moviesclone.feature_serie_details.domain.models.Season

class SeasonAdapter(
    private val values: List<Season>
) : RecyclerView.Adapter<SeasonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SeasonCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(values[position])
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: SeasonCardBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imagePreview: ImageView = binding.imageViewSeason
        private val textViewTitle: TextView = binding.materialTextViewName
        private val textViewDescription: TextView = binding.materialTextViewDescription

        private val requestOption: RequestOptions =
            RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.ic_broken_image)
                .placeholder(R.drawable.ic_preview_image)

        fun bind(season: Season) {

            Glide.with(itemView.context).load("$URL_DOWNLOAD_IMAGE${season.posterPath}")
                .apply(requestOption)
                .centerCrop()
                .into(imagePreview)

            textViewTitle.text = season.name
            textViewDescription.text = season.overview
        }

    }

}