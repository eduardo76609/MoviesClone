package com.example.moviesclone.feature_serie_details.presentation

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.moviesclone.databinding.GenreTextviewBinding
import com.example.moviesclone.feature_serie_details.domain.models.Genre

class GenreAdapter(
    private val values: List<Genre>
) : RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            GenreTextviewBinding.inflate(
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

    inner class ViewHolder(binding: GenreTextviewBinding) : RecyclerView.ViewHolder(binding.root) {
        private val textViewGenre: TextView = binding.TextViewGenre

        fun bind(genre: Genre) {
            textViewGenre.text = genre.name
        }

    }

}