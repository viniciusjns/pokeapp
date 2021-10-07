package com.vinicius.pokeapp.pokemonlist.domain.useCase

import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainErrorModel
import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainModel
import com.vinicius.pokeapp.core.util.Result

interface GetPokemonsUseCase {
    suspend operator fun invoke(): Result<List<PokemonListDomainModel>, PokemonListDomainErrorModel>
}