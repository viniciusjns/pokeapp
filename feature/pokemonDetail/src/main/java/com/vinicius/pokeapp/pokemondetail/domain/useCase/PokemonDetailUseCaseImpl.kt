package com.vinicius.pokeapp.pokemondetail.domain.useCase

import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.pokemondetail.data.repository.PokemonDetailRepository
import com.vinicius.pokeapp.pokemondetail.domain.mapper.PokemonDetailDomainMapper
import com.vinicius.pokeapp.pokemondetail.domain.model.*
import javax.inject.Inject

class PokemonDetailUseCaseImpl @Inject constructor(
    private val pokemonDetailRepository: PokemonDetailRepository,
    private val pokemonDetailDomainMapper: PokemonDetailDomainMapper,
) : PokemonDetailUseCase {

    override suspend fun getPokemonById(id: Int): Result<PokemonDetailDomainModel, String> =
        pokemonDetailRepository.getPokemonById(id)
            .mapSuccess {
                pokemonDetailDomainMapper.mapFrom(it)
            }
            .mapError { "" }
}