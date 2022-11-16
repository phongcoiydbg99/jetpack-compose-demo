package com.example.firstjen.database

import com.example.firstjen.database.model.HotelEntity
import kotlinx.coroutines.flow.Flow

interface HotelLocalRepository {

    fun getHotelEntityStream(hotelId: String): Flow<HotelEntity>

    fun getHotelEntitiesStream(): Flow<List<HotelEntity>>

    suspend fun updateHotels(entities: List<HotelEntity>)

    suspend fun deleteHotels(ids: List<String>)
}