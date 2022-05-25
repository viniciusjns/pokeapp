package com.vinicius.pokeapp.pokemondetail.domain.repository

import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonDetailDomainModel
import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonSpecieDomainModel

interface PokemonDetailRepository {
    suspend fun getPokemonById(id: Int): Result<PokemonDetailDomainModel, ResultError>
    suspend fun getPokemonSpecie(pokemonId: Int): Result<PokemonSpecieDomainModel, ResultError>
//    suspend fun getPokemonEvolutionChain(chainId: Int): Result<PokemonEvolutionDomainModel, ResultError>
}