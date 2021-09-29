package com.vinicius.pokeapp.pokemonlist.presentation.mapper

import com.vinicius.pokeapp.core.mapper.Mapper
import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainModel
import com.vinicius.pokeapp.pokemonlist.presentation.model.PokemonListUiModel
import javax.inject.Inject

class PokemonListPresentationMapper @Inject constructor(

): Mapper<PokemonListDomainModel, PokemonListUiModel> {
    override fun mapFrom(from: PokemonListDomainModel): PokemonListUiModel {
        return PokemonListUiModel(
            id = from.id,
            name = from.name,
            types = from.types,
            imageUrl = from.imageUrl,
        )
    }
}