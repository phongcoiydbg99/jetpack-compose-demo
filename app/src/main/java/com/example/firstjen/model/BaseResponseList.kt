package com.example.firstjen.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BaseResponseList<T>(
        @Expose @SerializedName("total") val total: Int?,
        @Expose @SerializedName("items") val items: MutableList<T>?,
)