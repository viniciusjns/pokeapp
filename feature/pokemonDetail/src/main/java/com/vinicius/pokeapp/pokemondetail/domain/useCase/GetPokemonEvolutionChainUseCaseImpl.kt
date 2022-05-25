package com.vinicius.pokeapp.pokemondetail.domain.useCase

import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonEvolutionDomainModel
import com.vinicius.pokeapp.pokemondetail.domain.repository.PokemonDetailRepository
import javax.inject.Inject

class GetPokemonEvolutionChainUseCaseImpl @Inject constructor(
    private val repository: PokemonDetailRepository
) : GetPokemonEvolutionChainUseCase {

    override suspend fun invoke(chainId: Int): Result<List<PokemonEvolutionDomainModel>, ResultError> =
        repository.getPokemonEvolutionChain(chainId)
}