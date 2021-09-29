package com.vinicius.pokeapp.pokemondetail.data.repository

import com.vinicius.pokeapp.service.response.Result
import com.vinicius.pokeapp.pokemondetail.data.model.PokemonDetailDataModel

interface PokemonDetailRepository {

    suspend fun getPokemonById(id: Int): Result<PokemonDetailDataModel, String>
}