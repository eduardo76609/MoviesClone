package com.example.moviesclone.core.network

sealed class RequestResult<out T> {
    data class Success<out T>(val data: T?) : RequestResult<T>()
    data class Failure(val errorData: ErrorResponse) : RequestResult<Nothing>()
}