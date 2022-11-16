package com.example.firstjen.di

import com.example.firstjen.repository.HotelRepository
import com.example.firstjen.repository.HotelRepositoryImpl
import com.example.firstjen.repository.PokemonRepository
import com.example.firstjen.repository.PokemonRepositoryImpl
import com.example.firstjen.service.HotelService
import com.example.firstjen.service.PokemonService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideHotelRepository(api: HotelService): HotelRepository = HotelRepositoryImpl(api)

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokemonService,
    ): PokemonRepository {
        return PokemonRepositoryImpl(api)
    }
}