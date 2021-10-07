package com.vinicius.pokeapp.pokemonlist.domain.model

sealed class PokemonListDomainErrorModel {
    object NetworkError: PokemonListDomainErrorModel()
    object GenericError: PokemonListDomainErrorModel()
}