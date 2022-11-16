package com.example.firstjen.repository

import com.example.firstjen.model.BaseResponse
import com.example.firstjen.model.BaseResponseList
import com.example.firstjen.model.HotelListingRequest
import com.example.firstjen.navigation.JenRoute
import com.example.firstjen.service.HotelService
import kotlinx.coroutines.flow.Flow

class HotelRepositoryImpl(
    val hotelService: HotelService
) : HotelRepository {
    override fun getChainTopHotelsAsync(request: HotelListingRequest): Flow<BaseResponse<BaseResponseList<JenRoute.Hotel>>> {
        return hotelService.getChainTopHotelsAsync(request)
    }
}