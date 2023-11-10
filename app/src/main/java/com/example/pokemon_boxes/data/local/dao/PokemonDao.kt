package com.example.pokemon_boxes.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.pokemon_boxes.data.local.entity.Pokemon
import kotlinx.coroutines.flow.Flow

// data access object for db CRUD
@Dao
interface PokemonDao {

    @Query("SELECT * FROM Pokemon")
    fun getAllPokemon(): Flow<List<Pokemon>>

    @Query(
        """SELECT * FROM Pokemon
            WHERE id = :id"""
    )
    suspend fun getPokemonById(id: Int): Pokemon

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun createPokemon(pokemon: Pokemon)

    @Delete
    suspend fun deletePokemon(pokemon: Pokemon)

    @Update
    suspend fun updatePokemon(pokemon: Pokemon)
}