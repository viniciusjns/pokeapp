package com.vinicius.pokeapp.pokemondetail.data.mapper

import com.vinicius.pokeapp.pokemondetail.data.model.ChainResponse
import com.vinicius.pokeapp.pokemondetail.data.model.PokemonEvolutionResponse
import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonEvolutionDomainModel

fun PokemonEvolutionResponse.toPokemonEvolutionDomainModel(): List<PokemonEvolutionDomainModel> =
    getPokemonDomain(mutableListOf(), chain)

private fun getPokemonDomain(list: MutableList<PokemonEvolutionDomainModel>, chain: ChainResponse): List<PokemonEvolutionDomainModel> {
    val idBasePokemon: Int? = chain.species.url.getIdByUrl()

    if (chain.evolvesTo.isNotEmpty()) {
        val levelToEvolve = chain.evolvesTo.first().evolutionDetails.first().minLevel
        val idEvolvedPokemon = chain.evolvesTo.first().species.url.getIdByUrl()
        list.add(
            PokemonEvolutionDomainModel(
                idBasePokemon = idBasePokemon,
                levelToEvolve = levelToEvolve ?: 0,
                idEvolvedPokemon = idEvolvedPokemon
            )
        )
        return getPokemonDomain(list, chain.evolvesTo.first())
    }

    return list
}

private fun String.getIdByUrl() = split("/".toRegex()).dropLast(1).last().toIntOrNull()