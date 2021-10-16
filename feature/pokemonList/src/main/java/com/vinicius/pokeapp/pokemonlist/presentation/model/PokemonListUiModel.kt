package com.vinicius.pokeapp.pokemonlist.presentation.model

import android.os.Parcelable
import com.vinicius.pokeapp.core.model.BasePokemonUiModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonListUiModel(
    override val id: String,
    override val name: String,
    override val types: List<String>?,
    override val imageUrl: String?,
) : BasePokemonUiModel(id, name, types, imageUrl), Parcelable
