package com.vinicius.pokeapp.pokemondetail.data.mapper

import com.vinicius.pokeapp.pokemondetail.data.model.ChainResponse
import com.vinicius.pokeapp.pokemondetail.data.model.PokemonEvolutionResponse
import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonEvolutionDomainModel

fun PokemonEvolutionResponse.toPokemonEvolutionDomainModel(): List<PokemonEvolutionDomainModel> =
    getPokemonDomain(mutableListOf(), chain)

private fun getPokemonDomain(list: MutableList<PokemonEvolutionDomainModel>, chain: ChainResponse): List<PokemonEvolutionDomainModel> {
    val idBasePokemon: Int = chain.species.url.getIdByUrl()
    val nameBasePokemon: String = chain.species.name

    if (chain.evolvesTo.isNotEmpty()) {
        chain.evolvesTo.first().run {
            val levelToEvolve = evolutionDetails.first().minLevel
            val idEvolvedPokemon = species.url.getIdByUrl()
            val nameEvolvedPokemon = species.name
            list.add(
                PokemonEvolutionDomainModel(
                    idBasePokemon = idBasePokemon,
                    nameBasePokemon = nameBasePokemon,
                    levelToEvolve = levelToEvolve,
                    idEvolvedPokemon = idEvolvedPokemon,
                    nameEvolvedPokemon = nameEvolvedPokemon
                )
            )
            return getPokemonDomain(list, this)
        }
    }

    return list
}

private fun String.getIdByUrl() = split("/".toRegex()).dropLast(1).last().toInt()