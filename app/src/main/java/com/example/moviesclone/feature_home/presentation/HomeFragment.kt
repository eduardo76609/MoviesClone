package com.example.moviesclone.feature_home.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.moviesclone.R
import com.example.moviesclone.databinding.FragmentHomeBinding
import com.example.moviesclone.feature_movie_details.presentation.MovieDetailActivity
import com.example.moviesclone.feature_serie_details.presentation.SerieDetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val homeViewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.progressVisibility.observe(viewLifecycleOwner) { value ->
            Log.i("", "")
        }

        homeViewModel.animationMovies.observe(viewLifecycleOwner){ value ->
            binding.RecyclerViewAnimationMovies.adapter = MovieAdapter(value, ::goToMovieDetail)
        }

        homeViewModel.animationSeries.observe(viewLifecycleOwner){ value ->
            binding.RecyclerViewAnimationSeries.adapter = MovieAdapter(value, ::goToSerieDetail)
        }

        homeViewModel.comedyMovies.observe(viewLifecycleOwner){ value ->
            binding.RecyclerViewComedyMovies.adapter = MovieAdapter(value, ::goToMovieDetail)
        }

        homeViewModel.comedySeries.observe(viewLifecycleOwner){ value ->
            binding.RecyclerViewComedySeries.adapter = MovieAdapter(value, ::goToSerieDetail)
        }

        homeViewModel.getAnimationMovies()
        homeViewModel.getAnimationSeries()

        homeViewModel.getComedyMovies()
        homeViewModel.getComedySeries()
    }

    private fun goToMovieDetail(movieId: String) {
        startActivity(MovieDetailActivity.getIntent(requireContext(), movieId))
    }

    private fun goToSerieDetail(serieId: String) {
        startActivity(SerieDetailActivity.getIntent(requireContext(), serieId))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
