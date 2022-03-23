package com.example.moviesclone.core.network

import com.google.gson.Gson
import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException

const val UNKNOWN_CODE_ERROR = 99

const val TIMEOUT_CODE = 48
const val TIMEOUT_MESSAGE = "Timed out, please try again."

const val INTERNET_ACCESS_CODE = 49
const val INTERNET_ACCESS_MESSAGE = "Timed out, please try again."

abstract class ManageRequest {

    suspend fun <T> safeApiCall(call: suspend () -> Response<T>): RequestResult<T> {
        return try {
            val apiResponse = call.invoke()
            if (apiResponse.isSuccessful && apiResponse.code() == 200) {
                RequestResult.Success(apiResponse.body())
            } else {
                findMessageFromApiErrorCodes(apiResponse)
            }
        } catch (throwable: Throwable) {
            findExceptionType(throwable)
        }
    }

    private fun <T> findMessageFromApiErrorCodes(response: Response<T>): RequestResult<T> {
        response.let {
            val errorResponse: ErrorResponse = Gson().fromJson(
                response.errorBody()?.charStream()?.readText(),
                ErrorResponse::class.java
            )
            return RequestResult.Failure(
                errorResponse
            )
        }
    }

    private fun <T> findExceptionType(throwable: Throwable): RequestResult<T> {
        throwable.let {
            val error: ErrorResponse = when (throwable) {
                is SocketTimeoutException -> ErrorResponse(
                    TIMEOUT_CODE,
                    TIMEOUT_MESSAGE
                )
                is UnknownHostException -> ErrorResponse(
                    INTERNET_ACCESS_CODE,
                    INTERNET_ACCESS_MESSAGE
                )
                else -> ErrorResponse( UNKNOWN_CODE_ERROR, throwable.cause.toString())
            }
            return RequestResult.Failure(error)
        }
    }

}