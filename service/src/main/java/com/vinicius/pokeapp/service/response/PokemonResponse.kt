package com.vinicius.pokeapp.service.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonResponse(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "types") val types: List<String>?,
    @field:Json(name = "image") val imageUrl: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "species") val species: String?,
    @field:Json(name = "height") val height: Double?,
    @field:Json(name = "weight") val weight: Double?,
    @field:Json(name = "training") val training: Training?,
)

@JsonClass(generateAdapter = true)
data class Training(
    @field:Json(name = "evYield") val evYield: String?,
    @field:Json(name = "catchRate") val catchRate: CatchRate?,
    @field:Json(name = "baseFriendship") val baseFriendship: BaseFriendship?,
    @field:Json(name = "baseExp") val baseExp: Int?,
    @field:Json(name = "growthRate") val growthRate: String?,
)

@JsonClass(generateAdapter = true)
data class CatchRate(
    @field:Json(name = "value") val value: Int?,
    @field:Json(name = "text") val text: String?,
)

@JsonClass(generateAdapter = true)
data class BaseFriendship(
    @field:Json(name = "value") val value: Int?,
    @field:Json(name = "text") val text: String?,
)