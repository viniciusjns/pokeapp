package com.vinicius.pokeapp.pokemonlist.domain

import com.vinicius.pokeapp.core.data.Result

interface PokemonListUseCase {
    suspend fun fetchPokemons(): Result<List<PokemonListDomainModel>, String>
}