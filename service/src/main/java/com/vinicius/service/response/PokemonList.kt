package com.vinicius.service.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonList(
    @field:Json(name = "results") val results: List<Pokemon>
) {
}