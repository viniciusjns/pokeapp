package com.vinicius.pokeapp.pokemondetail.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonEvolutionResponse(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "chain") val chain: ChainResponse
)

data class ChainResponse(
    @field:Json(name = "is_baby") val isBaby: Boolean,
    @field:Json(name = "evolution_details") val evolutionDetails: List<EvolutionDetails>,
    @field:Json(name = "evolves_to") val evolvesTo: List<ChainResponse>,
    @field:Json(name = "species") val species: SpeciesResponse
)

data class EvolutionDetails(
    @field:Json(name = "min_level") val minLevel: Int
)

data class SpeciesResponse(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "url") val url: String
)