package com.example.firstjen.repository

import com.example.firstjen.model.BaseResponse
import com.example.firstjen.model.BaseResponseList
import com.example.firstjen.model.HotelListingRequest
import com.example.firstjen.navigation.JenRoute
import kotlinx.coroutines.flow.Flow

interface HotelRepository {

    fun getChainTopHotelsAsync(request: HotelListingRequest): Flow<BaseResponse<BaseResponseList<JenRoute.Hotel>>>

}