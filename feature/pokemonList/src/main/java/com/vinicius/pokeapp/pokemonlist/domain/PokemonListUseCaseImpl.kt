package com.vinicius.pokeapp.pokemonlist.domain

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.pokemonlist.data.repository.PokemonListRepository
import javax.inject.Inject

class PokemonListUseCaseImpl @Inject constructor(
    private val pokemonListRepository: PokemonListRepository
) : PokemonListUseCase {

    override suspend fun fetchPokemons(): Result<List<PokemonDomainModel>, String> {
        return pokemonListRepository.fetchPokemons().mapSuccess {
            it.map {
                PokemonDomainModel(
                    id = it.id,
                    name = it.name,
                    types = it.types,
                    imageUrl = it.imageUrl,
                    description = it.description,
                    species = it.species,
                    height = it.height,
                    weight = it.weight,
                    evYield = it.evYield,
                    catchRate = it.catchRate,
                    baseFriendship = it.baseFriendship,
                    baseExp = it.baseExp,
                    growthRate = it.growthRate,
                )
            }
        }
    }
}