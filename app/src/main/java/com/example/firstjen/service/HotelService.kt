package com.example.firstjen.service

import com.example.firstjen.model.BaseResponse
import com.example.firstjen.model.BaseResponseList
import com.example.firstjen.model.HotelListingRequest
import com.example.firstjen.navigation.JenRoute
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.POST

interface HotelService {

    @POST("hotels/v3/chains/top-hotels")
    fun getChainTopHotelsAsync(@Body request: HotelListingRequest): Flow<BaseResponse<BaseResponseList<JenRoute.Hotel>>>
}