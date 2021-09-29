package com.vinicius.pokeapp.pokemonlist.domain.useCase

import com.vinicius.pokeapp.service.response.Result
import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainModel

interface PokemonListUseCase {
    suspend fun fetchPokemons(): Result<List<PokemonListDomainModel>, String>
}