package com.vinicius.pokeapp.pokemonlist.data.mapper

import com.vinicius.pokeapp.core.mapper.Mapper
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonResponse
import javax.inject.Inject

class PokemonResponseToPokemonListDataMapper @Inject constructor(

) : Mapper<PokemonResponse, PokemonListDataModel> {
    override fun mapFrom(from: PokemonResponse): PokemonListDataModel {
        return PokemonListDataModel(
            id = from.id.toString(),
            name = from.name,
            types = from.types,
            imageUrl = from.imageUrl,
        )
    }
}