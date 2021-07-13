package com.vinicius.pokeapp.pokemonlist.domain

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.pokemonlist.data.repository.PokemonListRepository
import javax.inject.Inject

class PokemonListUseCaseImpl @Inject constructor(
    private val pokemonListRepository: PokemonListRepository
) : PokemonListUseCase {

    override suspend fun fetchPokemons(): Result<List<PokemonListDomainModel>, String> {
        return pokemonListRepository.fetchPokemons().mapSuccess {
            it.map {
                PokemonListDomainModel(
                    id = it.id,
                    name = it.name,
                    types = it.types,
                    imageUrl = it.imageUrl,
                )
            }
        }
    }
}