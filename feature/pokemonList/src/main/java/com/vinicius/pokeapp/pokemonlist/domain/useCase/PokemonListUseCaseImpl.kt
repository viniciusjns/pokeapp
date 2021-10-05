package com.vinicius.pokeapp.pokemonlist.domain.useCase

import com.vinicius.pokeapp.pokemonlist.domain.repository.PokemonListRepository
import com.vinicius.pokeapp.pokemonlist.domain.mapper.PokemonListDomainMapper
import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainModel
import com.vinicius.pokeapp.service.response.ResultWrapper
import javax.inject.Inject

class PokemonListUseCaseImpl @Inject constructor(
    private val pokemonListRepository: PokemonListRepository,
    private val pokemonListDomainMapper: PokemonListDomainMapper
) : PokemonListUseCase {

    override suspend fun getPokemons(): ResultWrapper<List<PokemonListDomainModel>> {
        return when(val result = pokemonListRepository.getPokemons()) {
            is ResultWrapper.Success -> {
                ResultWrapper.Success(
                    result.value.map { pokemonListDataModel ->
                        pokemonListDomainMapper.mapFrom(pokemonListDataModel)
                    }
                )
            }
            is ResultWrapper.Error -> {
                return result
            }
        }
    }
}