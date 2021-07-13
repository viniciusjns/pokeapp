package com.vinicius.pokeapp.pokemondetail.data.repository

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.pokemondetail.data.model.PokemonDataModel

interface PokemonDetailRepository {

    suspend fun getPokemonById(id: Int): Result<PokemonDataModel, String>
}