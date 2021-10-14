package com.vinicius.pokeapp.pokemondetail.presentation.view

sealed class PokemonDetailViewAction {
    data class GetPokemonById(val pokemonId: Int) : PokemonDetailViewAction()
}