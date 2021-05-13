package com.vinicius.pokeapp.pokemonlist.presentation

sealed class PokemonListViewAction {
    object FetchPokemonHeroku : PokemonListViewAction()
}