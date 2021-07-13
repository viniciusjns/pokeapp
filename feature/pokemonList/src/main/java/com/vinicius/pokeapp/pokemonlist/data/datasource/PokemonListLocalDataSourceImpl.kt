package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.service.PokemonSingleton
import javax.inject.Inject

class PokemonListLocalDataSourceImpl @Inject constructor(

) : PokemonListLocalDataSource {

    override suspend fun fetchPokemons(): Result<List<PokemonListDataModel>, String> {
        val result = PokemonSingleton.pokemonList.map {
            PokemonListDataModel(
                id = it.id.toString(),
                name = it.name,
                types = it.types,
                imageUrl = it.imageUrl,
            )
        }
        return if (result.isNullOrEmpty()) {
            Result.Error("")
        } else
            Result.Success(result)
    }
}