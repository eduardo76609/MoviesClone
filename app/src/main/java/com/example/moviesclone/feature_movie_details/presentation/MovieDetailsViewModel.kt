package com.example.moviesclone.feature_movie_details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesclone.core.network.RequestResult
import com.example.moviesclone.feature_movie_details.domain.models.MovieDetail
import com.example.moviesclone.feature_movie_details.domain.usecases.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
) :
    ViewModel() {

    private val _progressVisibility: MutableLiveData<Boolean> = MutableLiveData()
    val progressVisibility: LiveData<Boolean> = _progressVisibility

    private val _movieDetails: MutableLiveData<MovieDetail> = MutableLiveData()
    val movieDetails: LiveData<MovieDetail> = _movieDetails

    private val _errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessage: LiveData<String> = _errorMessage

    fun getMovieDetails(id: String) {
        _progressVisibility.value = true
        viewModelScope.launch {
            when (val result = getMovieDetailsUseCase.execute(id)) {
                is RequestResult.Success -> {
                    result.data.let {
                        _movieDetails.value = it
                    }
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