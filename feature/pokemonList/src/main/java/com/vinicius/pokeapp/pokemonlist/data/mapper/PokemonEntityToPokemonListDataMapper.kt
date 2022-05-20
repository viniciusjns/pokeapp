package com.vinicius.pokeapp.pokemonlist.data.mapper

import com.vinicius.pokeapp.core.mapper.Mapper
import com.vinicius.pokeapp.database.entity.PokemonEntity
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import javax.inject.Inject

class PokemonEntityToPokemonListDataMapper @Inject constructor(

) : Mapper<PokemonEntity, PokemonListDataModel> {
    override fun mapFrom(from: PokemonEntity): PokemonListDataModel {
        return PokemonListDataModel(
            id = from.id.toString(),
            name = from.name,
            types = from.types,
            imageUrl = from.imageUrl,
        )
    }
}