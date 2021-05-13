package com.vinicius.pokeapp.service.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Pokemon(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "types") val types: List<String>?,
    @field:Json(name = "image") val imageUrl: String?,
) {
    fun getNumber(): String {
        val number = id.toString().padStart(3, '0')
        return "#${number}"
    }
}