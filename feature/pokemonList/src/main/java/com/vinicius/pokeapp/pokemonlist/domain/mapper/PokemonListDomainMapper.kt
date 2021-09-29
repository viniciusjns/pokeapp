package com.vinicius.pokeapp.pokemonlist.domain.mapper

import com.vinicius.pokeapp.core.mapper.Mapper
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainModel
import javax.inject.Inject

class PokemonListDomainMapper @Inject constructor(

): Mapper<PokemonListDataModel, PokemonListDomainModel> {
    override fun mapFrom(from: PokemonListDataModel): PokemonListDomainModel {
        return PokemonListDomainModel(
            id = from.id,
            name = from.name,
            types = from.types,
            imageUrl = from.imageUrl,
        )
    }
}