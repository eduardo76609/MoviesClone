package com.example.moviesclone.feature_home.presentation

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.moviesclone.R
import com.example.moviesclone.common.URL_DOWNLOAD_IMAGE
import com.example.moviesclone.databinding.PreviewCardBinding
import com.example.moviesclone.feature_home.domain.models.Movie

class MovieAdapter(
    private val values: List<Movie>,
    private val onClickMovie: (String) -> Unit
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PreviewCardBinding.inflate(
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

    inner class ViewHolder(binding: PreviewCardBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imagePreview: ImageView = binding.imageViewPreview
        private val view: View = binding.root

        private val requestOption: RequestOptions =
            RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.ic_broken_image)
                .placeholder(R.drawable.ic_preview_image)

        fun bind(movie: Movie) {
            view.setOnClickListener {
                onClickMovie(movie.id.toString())
            }
            Glide.with(itemView.context).load("$URL_DOWNLOAD_IMAGE${movie.posterPath}")
                .apply(requestOption)
                .centerCrop()
                .into(imagePreview)
        }

    }

}