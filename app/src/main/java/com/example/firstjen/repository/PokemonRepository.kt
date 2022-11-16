package com.example.firstjen.repository

import com.example.firstjen.service.PokemonService
import com.example.re.data.response.ListingResponse
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun fetchPokemonList(): Flow<ListingResponse>
}

class PokemonRepositoryImpl(private val api: PokemonService): PokemonRepository {
    override suspend fun fetchPokemonList() = api.fetchPokemonList(20,0)
}