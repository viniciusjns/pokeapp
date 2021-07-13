package com.vinicius.pokeapp.service

import com.vinicius.pokeapp.service.response.PokemonResponse

object PokemonSingleton {
    val pokemonList = mutableListOf<PokemonResponse>()
}