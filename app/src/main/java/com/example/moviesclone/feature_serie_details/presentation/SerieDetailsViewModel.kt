package com.example.moviesclone.feature_serie_details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesclone.core.network.RequestResult
import com.example.moviesclone.feature_serie_details.domain.models.SerieDetail
import com.example.moviesclone.feature_serie_details.domain.usecases.GetSerieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SerieDetailsViewModel @Inject constructor(
    private val getSerieDetailsUseCase: GetSerieDetailsUseCase
) :
    ViewModel() {

    private val _progressVisibility: MutableLiveData<Boolean> = MutableLiveData()
    val progressVisibility: LiveData<Boolean> = _progressVisibility

    private val _serieDetails: MutableLiveData<SerieDetail> = MutableLiveData()
    val serieDetails: LiveData<SerieDetail> = _serieDetails

    private val _errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessage: LiveData<String> = _errorMessage

    fun getSerieDetails(id: String) {
        _progressVisibility.value = true
        viewModelScope.launch {
            when (val result = getSerieDetailsUseCase.execute(id)) {
                is RequestResult.Success -> {
                    result.data.let {
                        _serieDetails.value = it
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