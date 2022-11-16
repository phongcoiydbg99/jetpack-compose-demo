package com.example.firstjen.di

import android.content.Context
import androidx.room.Room
import com.example.firstjen.database.HotelDataSource
import com.example.firstjen.database.HotelLocalRepository
import com.example.firstjen.database.JenDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesNiaDatabase(
        @ApplicationContext context: Context,
    ): JenDatabase = Room.databaseBuilder(
        context,
        JenDatabase::class.java,
        "jen-database"
    ).build()
}

@Module
@InstallIn(SingletonComponent::class)
object HotelDataSourceModule {

    @Provides
    @Singleton
    fun providesHotelDataSource(
        database: JenDatabase
    ): HotelLocalRepository = HotelDataSource(
        database.hotelDao()
    )
}