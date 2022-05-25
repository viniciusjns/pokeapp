package com.vinicius.pokeapp.pokemondetail.presentation.view

sealed class PokemonEvolutionViewAction {
    data class GetPokemonSpecie(val pokemonId: Int) : PokemonEvolutionViewAction()
}