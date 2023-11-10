package com.example.pokemon_boxes.data.repository

import com.example.pokemon_boxes.domain.model.Pokemon
import com.example.pokemon_boxes.domain.repository.IPokemonRepository
import kotlinx.coroutines.flow.Flow

class PokemonRepository : IPokemonRepository {
    override fun getAllPokemon(): Flow<List<Pokemon>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPokemonById(id: Int): Pokemon? {
        TODO("Not yet implemented")
    }

    override suspend fun createPokemon(pokemon: Pokemon) {
        TODO("Not yet implemented")
    }

    override suspend fun updatePokemon(pokemon: Pokemon) {
        TODO("Not yet implemented")
    }

    override suspend fun deletePokemon(pokemon: Pokemon) {
        TODO("Not yet implemented")
    }
}