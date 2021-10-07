package com.vinicius.pokeapp.pokemonlist.presentation.mapper

import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainModel
import com.vinicius.pokeapp.pokemonlist.presentation.model.PokemonListUiModel
import org.junit.Test

class PokemonListPresentationMapperTest {

    private val mapper = PokemonListPresentationMapper()

    @Test
    fun mapFromPokemonListDataModel_toPokemonDomainDataModel() {
        val response = PokemonListDomainModel(
            id = "1",
            name = "Bulbasaur",
            types = emptyList(),
            imageUrl = ""
        )

        val expected = PokemonListUiModel(
            id = "1",
            name = "Bulbasaur",
            types = emptyList(),
            imageUrl = ""
        )

        val result = mapper.mapFrom(response)

        kotlin.test.assertEquals(expected.id, result.id)
        kotlin.test.assertEquals(expected.name, result.name)
        kotlin.test.assertEquals(expected.types, result.types)
        kotlin.test.assertEquals(expected.imageUrl, result.imageUrl)
    }
}