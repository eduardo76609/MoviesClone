package com.example.moviesclone.core.network

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("status_code") val statusCode: Int,
    @SerializedName("status_message") val statusMessage: String
) {

    override fun toString(): String {
        return "$statusCode - $statusMessage"
    }

}