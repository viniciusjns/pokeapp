package com.vinicius.pokeapp.pokemondetail.domain.useCase

import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonEvolutionDomainModel

interface GetPokemonEvolutionChainUseCase {
    suspend operator fun invoke(chainId: Int): Result<List<PokemonEvolutionDomainModel>, ResultError>
}