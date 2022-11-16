package com.example.firstjen.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.firstjen.database.dao.HotelDao
import com.example.firstjen.database.model.HotelEntity

@Database(
    entities = [
        HotelEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class JenDatabase : RoomDatabase() {
    abstract fun hotelDao(): HotelDao
}