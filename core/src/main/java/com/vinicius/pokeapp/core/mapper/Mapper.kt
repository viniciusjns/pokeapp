package com.vinicius.pokeapp.core.mapper

interface Mapper<FROM, TO> {
    fun mapFrom(from: FROM): TO
}