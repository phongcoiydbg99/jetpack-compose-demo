package com.example.firstjen.model

import com.google.gson.annotations.SerializedName

open class BaseResponse<DATA>(
        @SerializedName("code")
        val code: Int,

        @SerializedName("total")
        val total: Int? = null,

        @SerializedName("message")
        val message: String? = null,

        @SerializedName("access_token")
        val accessToken: String? = null,

        @SerializedName("data")
        val data: DATA? = null
) {

    fun success() = CODE_SUCCESS == code

    companion object {
        const val MESSAGE_SUCCESS = "successful"
        const val CODE_SUCCESS = 200
    }
}