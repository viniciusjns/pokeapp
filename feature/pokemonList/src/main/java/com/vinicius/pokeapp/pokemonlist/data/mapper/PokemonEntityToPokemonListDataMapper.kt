package com.vinicius.pokeapp.pokemonlist.data.mapper

import com.vinicius.pokeapp.core.mapper.Mapper
import com.vinicius.pokeapp.database.entity.PokemonEntity
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.service.response.*
import com.vinicius.pokeapp.service.response.Training
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