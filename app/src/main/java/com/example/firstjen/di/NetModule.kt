package com.example.firstjen.di

import com.example.firstjen.repository.HotelRepository
import com.example.firstjen.repository.HotelRepositoryImpl
import com.example.firstjen.service.HotelService
import com.example.firstjen.service.PokemonService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePokemonService(retrofit: Retrofit): PokemonService {
        return retrofit.create(PokemonService::class.java)
    }

    @Provides
    @Singleton
    fun provideHotelService(retrofit: Retrofit): HotelService {
        return retrofit.create(HotelService::class.java)
    }

}