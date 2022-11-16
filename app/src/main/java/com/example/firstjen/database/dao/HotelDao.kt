package com.example.firstjen.database.dao

import androidx.room.*
import com.example.firstjen.database.model.HotelEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HotelDao {
    @Query(
        value = """
        SELECT * FROM hotels
        WHERE id = :hotelId
    """
    )
    fun getHotelEntityStream(hotelId: String): Flow<HotelEntity>

    @Query(value = "SELECT * FROM hotels")
    fun getHotelEntitiesStream(): Flow<List<HotelEntity>>

    /**
     * Inserts [hotelEntities] into the db if they don't exist, and ignores those that do
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreHotels(hotelEntities: List<HotelEntity>): List<Long>

    /**
     * Updates [entities] in the db that match the primary key, and no-ops if they don't
     */
    @Update
    suspend fun updateHotels(entities: List<HotelEntity>)

    /**
     * Deletes rows in the db matching the specified [ids]
     */
    @Query(
        value = """
            DELETE FROM hotels
            WHERE id in (:ids)
        """
    )
    suspend fun deleteHotels(ids: List<String>)
}