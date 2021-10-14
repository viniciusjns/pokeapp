package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.database.entity.PokemonEntity
import com.vinicius.pokeapp.service.response.PokemonResponse

interface PokemonListRemoteDataSource {
    suspend fun getPokemons(): Result<List<PokemonResponse>, ResultError>
}