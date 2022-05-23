package com.vinicius.pokeapp.pokemondetail.presentation.view

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vinicius.pokeapp.core.views.BaseFragment
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonAboutModel
import com.vinicius.pokemondetail.databinding.PokemonAboutFragmentBinding

private const val POKEMON = "POKEMON"

class PokemonAboutFragment : BaseFragment() {
    private var pokemon: PokemonAboutModel? = null

    private lateinit var binding: PokemonAboutFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pokemon = it.getParcelable(POKEMON)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PokemonAboutFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView(pokemon)
    }

    private fun setupView(pokemon: PokemonAboutModel?) = with(binding) {
        pokemon?.run {
            tvAboutDescription.text = description
            tvPokedexDataTitle.setTextColor(baseColor)
            tvSpeciesLabel.text = species
            tvHeightLabel.text = height
            tvWeightLabel.text = weight
            tvTrainingTitle.setTextColor(baseColor)
            tvEvyieldLabel.text = evYield
            tvCatchRateLabel.text = catchRate
            tvBaseFriendshipLabel.text = baseFriendship
            tvBaseExpLabel.text = pokemon.baseExp
            tvGrowthRateLabel.text = growthRate
            tvBreedingTitle.setTextColor(baseColor)
            tvGenderLabel.text = gender
            tvEggGroupsLabel.text = eggGroups
            tvEggCyclesLabel.text = eggCycles
        }
    }

    companion object {
        fun newInstance(pokemon: PokemonAboutModel?) =
            PokemonAboutFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(POKEMON, pokemon)
                }
            }
    }
}