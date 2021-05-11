package com.vinicius.pokeapp.service.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Pokemon(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "url") val url: String?,
    @field:Json(name = "types") val types: List<String>?,
    @field:Json(name = "image") val image: String?,
) {
    private fun getCode() = url?.split("/".toRegex())?.dropLast(1)?.last() ?: id.toString()

    fun getCapsName(): String = name.substring(0).capitalize()

    fun getImageUrl(): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${getCode()}.png"
    }

    fun getNumber(): String {
        val number = getCode()?.padStart(3, '0')
        return "#${number}"
    }
}