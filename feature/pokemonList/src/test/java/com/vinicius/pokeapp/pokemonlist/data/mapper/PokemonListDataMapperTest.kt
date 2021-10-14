package com.vinicius.pokeapp.pokemonlist.data.mapper

import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.service.response.PokemonResponse
import org.junit.Test
import kotlin.test.assertEquals

class PokemonListDataMapperTest {

    private val mapper = PokemonResponseToPokemonListDataMapper()

    @Test
    fun mapFromPokemonResponse_toPokemonListDataModel() {
        val response = PokemonResponse(
            id = 1,
            name = "Bulbasaur",
            types = emptyList(),
            imageUrl = "",
            description = "",
            species = "",
            height = null,
            weight = null,
            training = null,
            breedings = null,
            baseStats = null,
            typeDefenses = null
        )

        val expected = PokemonListDataModel(
            id = "1",
            name = "Bulbasaur",
            types = emptyList(),
            imageUrl = ""
        )

        val result = mapper.mapFrom(response)

        assertEquals(expected.id, result.id)
        assertEquals(expected.name, result.name)
        assertEquals(expected.types, result.types)
        assertEquals(expected.imageUrl, result.imageUrl)
    }
}