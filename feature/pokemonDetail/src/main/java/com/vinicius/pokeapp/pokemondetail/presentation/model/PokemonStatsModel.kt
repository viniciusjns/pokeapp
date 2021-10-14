package com.vinicius.pokeapp.pokemondetail.presentation.model

import android.os.Parcelable
import com.vinicius.pokemondetail.R
import kotlinx.parcelize.Parcelize

@Parcelize
class PokemonStatsModel(
    val hp: List<String>?,
    val attack: List<String>?,
    val defense: List<String>?,
    val specialAttack: List<String>?,
    val specialDefense: List<String>?,
    val speed: List<String>?,
    val typeDefenses: List<Pair<TypeDefense, String?>>,
    val baseColor: Int?
) : Parcelable

enum class TypeDefense(val icon: Int) {
    BUG(R.drawable.ic_type_bug),
    DARK(R.drawable.ic_type_dark),
    DRAGON(R.drawable.ic_type_dragon),
    ELECTRIC(R.drawable.ic_type_electric),
    FAIRY(R.drawable.ic_type_fairy),
    FIGHTING(R.drawable.ic_type_fighting),
    FIRE(R.drawable.ic_type_fire),
    FLYING(R.drawable.ic_type_flying),
    GHOST(R.drawable.ic_type_ghost),
    GRASS(R.drawable.ic_type_grass),
    GROUND(R.drawable.ic_type_ground),
    ICE(R.drawable.ic_type_ice),
    NORMAL(R.drawable.ic_type_normal),
    POISON(R.drawable.ic_type_poison),
    PSYCHIC(R.drawable.ic_type_psychic),
    ROCK(R.drawable.ic_type_rock),
    STEEL(R.drawable.ic_type_steel),
    WATER(R.drawable.ic_type_water),
}