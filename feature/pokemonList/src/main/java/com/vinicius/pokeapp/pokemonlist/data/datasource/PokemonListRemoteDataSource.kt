package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonResponse

interface PokemonListRemoteDataSource {
    suspend fun getPokemons(): Result<List<PokemonResponse>, ResultError>
}