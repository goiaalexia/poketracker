package com.example.pokemon_boxes.data.local

import androidx.room.Database
import com.example.pokemon_boxes.data.local.dao.PokemonDao
import com.example.pokemon_boxes.data.local.entity.Pokemon

@Database(version = 1, entities = [Pokemon::class])
abstract class PokemonDatabase {
    abstract val dao: PokemonDao;

    companion object {
        const val name = "pokemon_db"
    }
}