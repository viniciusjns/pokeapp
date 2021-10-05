package com.vinicius.pokeapp.pokemonlist.presentation.view

sealed class PokemonListViewAction {
    object FetchPokemons : PokemonListViewAction()
}