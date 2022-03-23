package com.example.moviesclone.feature_home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesclone.common.ANIMATION
import com.example.moviesclone.common.COMEDY
import com.example.moviesclone.core.network.RequestResult
import com.example.moviesclone.feature_home.domain.models.Movie
import com.example.moviesclone.feature_home.domain.usecases.GetMoviesByGenreUseCase
import com.example.moviesclone.feature_home.domain.usecases.GetSeriesByGenreUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviesByGenreUseCase: GetMoviesByGenreUseCase,
    private val getSeriesByGenreUseCase: GetSeriesByGenreUseCase
) : ViewModel() {

    private val _progressVisibility: MutableLiveData<Boolean> = MutableLiveData()
    val progressVisibility: LiveData<Boolean> = _progressVisibility

    private val _animationMovies: MutableLiveData<List<Movie>> = MutableLiveData()
    val animationMovies: LiveData<List<Movie>> = _animationMovies

    private val _animationSeries: MutableLiveData<List<Movie>> = MutableLiveData()
    val animationSeries: LiveData<List<Movie>> = _animationSeries

    private val _comedyMovies: MutableLiveData<List<Movie>> = MutableLiveData()
    val comedyMovies: LiveData<List<Movie>> = _comedyMovies

    private val _comedySeries: MutableLiveData<List<Movie>> = MutableLiveData()
    val comedySeries: LiveData<List<Movie>> = _comedySeries

    private val _errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessage: LiveData<String> = _errorMessage

    fun getAnimationMovies() {
        _progressVisibility.value = true
        viewModelScope.launch {
            when (val result = getMoviesByGenreUseCase.execute(ANIMATION)) {
                is RequestResult.Success -> {
                    _animationMovies.value = result.data?.results
                }
                is RequestResult.Failure -> {
                    _errorMessage.value = result.errorData.toString()
                }
            }
        }.invokeOnCompletion {
            _progressVisibility.value = false
        }
    }

    fun getAnimationSeries() {
        _progressVisibility.value = true
        viewModelScope.launch {
            when (val result = getSeriesByGenreUseCase.execute(ANIMATION)) {
                is RequestResult.Success -> {
                    _animationSeries.value = result.data?.results
                }
                is RequestResult.Failure -> {
                    _errorMessage.value = result.errorData.toString()
                }
            }
        }.invokeOnCompletion {
            _progressVisibility.value = false
        }
    }

    fun getComedyMovies() {
        _progressVisibility.value = true
        viewModelScope.launch {
            when (val result = getMoviesByGenreUseCase.execute(COMEDY)) {
                is RequestResult.Success -> {
                    _comedyMovies.value = result.data?.results
                }
                is RequestResult.Failure -> {
                    _errorMessage.value = result.errorData.toString()
                }
            }
        }.invokeOnCompletion {
            _progressVisibility.value = false
        }
    }

    fun getComedySeries() {
        _progressVisibility.value = true
        viewModelScope.launch {
            when (val result = getSeriesByGenreUseCase.execute(COMEDY)) {
                is RequestResult.Success -> {
                    _comedySeries.value = result.data?.results
                }
                is RequestResult.Failure -> {
                    _errorMessage.value = result.errorData.toString()
                }
            }
        }.invokeOnCompletion {
            _progressVisibility.value = false
        }
    }

}