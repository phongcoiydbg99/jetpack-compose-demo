package com.example.firstjen.database.dao

import androidx.room.*
import com.example.firstjen.database.model.PokemonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Query(
        value = """
        SELECT * FROM pokemons
        WHERE id = :pokemonId
    """
    )
    fun getPokemonEntityStream(pokemonId: String): Flow<PokemonEntity>

    @Query(value = "SELECT * FROM pokemons")
    fun getPokemonEntitiesStream(): Flow<List<PokemonEntity>>

    /**
     * Inserts [pokemonEntities] into the db if they don't exist, and ignores those that do
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnorePokemons(pokemonEntities: List<PokemonEntity>): List<Long>

    /**
     * Updates [entities] in the db that match the primary key, and no-ops if they don't
     */
    @Update
    suspend fun updatePokemons(entities: List<PokemonEntity>)

    /**
     * Deletes rows in the db matching the specified [ids]
     */
    @Query(
        value = """
            DELETE FROM pokemons
            WHERE id in (:ids)
        """
    )
    suspend fun deletePokemons(ids: List<String>)
}