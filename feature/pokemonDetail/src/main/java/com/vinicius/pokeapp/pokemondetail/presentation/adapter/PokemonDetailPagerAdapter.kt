package com.vinicius.pokeapp.pokemondetail.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.vinicius.pokeapp.pokemondetail.presentation.view.PokemonAboutFragment
import com.vinicius.pokeapp.pokemondetail.presentation.view.PokemonEvolutionFragment
import com.vinicius.pokeapp.pokemondetail.presentation.view.PokemonStatsFragment
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonDetailUiModel

class PokemonDetailPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val titles: List<String>
) : FragmentStateAdapter(fragmentActivity) {

    private lateinit var pokemon: PokemonDetailUiModel

    override fun getItemCount() = titles.size

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> PokemonAboutFragment.newInstance(pokemon.pokemonAboutModel)
            1 -> PokemonStatsFragment.newInstance(pokemon.pokemonStatsModel)
            2 -> PokemonEvolutionFragment.newInstance(pokemon.pokemonEvolutionModel)
            else -> PokemonAboutFragment.newInstance(pokemon.pokemonAboutModel)
        }

    fun updatePokemon(pokemonUpdated: PokemonDetailUiModel) {
        this.pokemon = pokemonUpdated
    }

}