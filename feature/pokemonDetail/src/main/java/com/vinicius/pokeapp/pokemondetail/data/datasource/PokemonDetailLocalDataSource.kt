package com.vinicius.pokeapp.pokemondetail.data.datasource

import com.vinicius.pokeapp.service.response.Result
import com.vinicius.pokeapp.pokemondetail.data.model.PokemonDetailDataModel

interface PokemonDetailLocalDataSource {

    suspend fun getPokemonById(id: Int): Result<PokemonDetailDataModel, String>
}