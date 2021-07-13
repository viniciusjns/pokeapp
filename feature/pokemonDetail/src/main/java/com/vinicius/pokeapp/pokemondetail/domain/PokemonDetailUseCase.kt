package com.vinicius.pokeapp.pokemondetail.domain

import com.vinicius.pokeapp.core.data.Result

interface PokemonDetailUseCase {
    suspend fun getPokemonById(id: Int): Result<PokemonDomainModel, String>
}