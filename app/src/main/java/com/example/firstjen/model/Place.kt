package com.example.re.data.response

import android.content.Context
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Place(
    var localId: Int? = null,

    @SerializedName("addressTypeName")
    var name: String? = null,

    @SerializedName("address")
    var address: String? = null,

    @SerializedName("primaryAddress")
    var primaryAddress: String? = null,

    @SerializedName("secondaryAddress")
    var secondaryAddress: String? = null,

    @SerializedName("note")
    var note: String? = null,

    @SerializedName("addressTypeCode")
    var type: String? = null,

    @SerializedName("latitude")
    var lat: Double? = null,

    @SerializedName("longitude")
    var lng: Double? = null,

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("default")
    var isDefault: Boolean = false,

    @SerializedName("latestPickTime")
    var latestPickTime: Long = 0L,

    var lastRefreshed: Date? = null

) : Parcelable {
    companion object {
        const val HOME = "HOME"
        const val COMPANY = "COMPANY"
        const val OTHER = "OTHER"
    }
}
