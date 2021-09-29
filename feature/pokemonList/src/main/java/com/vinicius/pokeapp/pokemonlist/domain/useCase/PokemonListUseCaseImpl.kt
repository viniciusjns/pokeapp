package com.vinicius.pokeapp.pokemonlist.domain.useCase

import com.vinicius.pokeapp.service.response.Result
import com.vinicius.pokeapp.pokemonlist.data.repository.PokemonListRepository
import com.vinicius.pokeapp.pokemonlist.domain.mapper.PokemonListDomainMapper
import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainModel
import javax.inject.Inject

class PokemonListUseCaseImpl @Inject constructor(
    private val pokemonListRepository: PokemonListRepository,
    private val pokemonListDomainMapper: PokemonListDomainMapper
) : PokemonListUseCase {

    override suspend fun fetchPokemons(): Result<List<PokemonListDomainModel>, String> {
        return pokemonListRepository.fetchPokemons().mapSuccess {
            it.map { pokemonListDataModel ->
                pokemonListDomainMapper.mapFrom(pokemonListDataModel)
            }
        }
    }
}