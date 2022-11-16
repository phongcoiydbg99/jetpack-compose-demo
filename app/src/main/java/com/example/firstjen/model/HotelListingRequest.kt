package com.example.firstjen.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
class HotelListingRequest(
    @SerializedName("checkIn")
    @Expose
    var checkIn: String? = null,
    @SerializedName("checkOut")
    @Expose
    var checkOut: String? = null,
    @SerializedName("adults")
    @Expose
    var adults: Short = 2,
    @SerializedName("children")
    @Expose
    var children: Short = 0,
    @SerializedName("childrenAges")
    @Expose
    var childrenAges: MutableList<Int>? = null,
    @SerializedName("rooms")
    @Expose
    var rooms: Short = 1,
    @SerializedName("searchType")
    @Expose
    var searchType: String? = null,
    @SerializedName("aliasCode")
    @Expose
    var aliasCode: String? = null,
    @SerializedName("hotelIds")
    @Expose
    var hotelIds: MutableList<Long>? = null,

    @Expose
    @SerializedName("province")
    var province: Long? = null,

    @Expose
    @SerializedName("provinceId")
    var provinceId: Long? = null,
    @Expose
    @SerializedName("provinceName")
    var provinceName: String? = null,

    @Expose
    @SerializedName("districtId")
    var districtId: Long? = null,
    @Expose
    @SerializedName("districtName")
    var districtName: String? = null,

    @SerializedName("chainId")
    @Expose
    var chainId: Long? = null,
    @SerializedName("latitude")
    @Expose
    var latitude: Double? = null,
    @SerializedName("longitude")
    @Expose
    var longitude: Double? = null,
    @SerializedName("radius")
    @Expose
    var radius: Float? = null,
    @SerializedName("sortBy")
    @Expose
    var sortBy: String? = null,
    @Expose
    @SerializedName("expandEntirePlace")
    var expandEntirePlace: Boolean? = true,
    @SerializedName("page")
    @Expose
    var page: Short? = 1,
    @SerializedName("size")
    @Expose
    var size: Int? = 24,

) : Parcelable