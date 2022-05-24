package com.vinicius.pokeapp.pokemonlist.domain.mapper

import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainModel
import org.junit.Test

class PokemonListDomainMapperTest {

    private val mapper = PokemonListDomainMapper()

    @Test
    fun mapFromPokemonListDataModel_toPokemonDomainDataModel() {
        val response = PokemonListDataModel(
            id = "1",
            name = "Bulbasaur",
            types = emptyList(),
            imageUrl = ""
        )

        val expected = PokemonListDomainModel(
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