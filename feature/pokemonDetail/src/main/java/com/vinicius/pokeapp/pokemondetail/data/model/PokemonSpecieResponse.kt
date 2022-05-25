package com.vinicius.pokeapp.pokemondetail.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonSpecieResponse(
    @field:Json(name = "evolution_chain") val evolutionChain: EvolutionChainResponse
) {
    val evolutionChainId: Int? =
        evolutionChain.url.split("/".toRegex()).dropLast(1).last().toIntOrNull()
}

@JsonClass(generateAdapter = true)
data class EvolutionChainResponse(
    @field:Json(name = "url") val url: String
)
