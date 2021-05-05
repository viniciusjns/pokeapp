package com.vinicius.pokeapp.service.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.vinicius.pokeapp.service.response.Pokemon

@JsonClass(generateAdapter = true)
data class PokemonList(
    @field:Json(name = "results") val results: List<Pokemon>
) {
}