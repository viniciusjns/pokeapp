package com.vinicius.pokeapp.pokemonlist.domain.repository

import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainModel

interface PokemonListRepository {
    suspend fun getPokemons(): Result<List<PokemonListDomainModel>, ResultError>
}