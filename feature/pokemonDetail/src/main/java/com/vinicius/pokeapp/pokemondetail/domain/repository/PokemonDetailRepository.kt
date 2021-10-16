package com.vinicius.pokeapp.pokemondetail.domain.repository

import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.pokemondetail.data.model.PokemonDetailDataModel

interface PokemonDetailRepository {
    suspend fun getPokemonById(id: Int): Result<PokemonDetailDataModel, ResultError>
}