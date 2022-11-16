package com.example.firstjen.database

import com.example.firstjen.database.dao.HotelDao
import com.example.firstjen.database.model.HotelEntity
import kotlinx.coroutines.flow.Flow

class HotelDataSource(
    private val hotelDao: HotelDao
) : HotelLocalRepository {
    override fun getHotelEntityStream(hotelId: String): Flow<HotelEntity> {
        return hotelDao.getHotelEntityStream(hotelId)
    }

    override fun getHotelEntitiesStream(): Flow<List<HotelEntity>> {
        return hotelDao.getHotelEntitiesStream()
    }

    override suspend fun updateHotels(entities: List<HotelEntity>) {
        hotelDao.updateHotels(entities)
    }

    override suspend fun deleteHotels(ids: List<String>) {
        hotelDao.deleteHotels(ids)
    }
}