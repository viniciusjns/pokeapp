package com.vinicius.pokeapp.pokemonlist.presentation.view

sealed class PokemonListViewAction {
    object GetPokemons : PokemonListViewAction()
}