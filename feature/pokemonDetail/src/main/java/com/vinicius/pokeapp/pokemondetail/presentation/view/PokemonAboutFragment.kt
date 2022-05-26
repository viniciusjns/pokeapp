package com.vinicius.pokeapp.pokemondetail.presentation.view

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.text.*
import com.vinicius.pokeapp.core.views.BaseFragment
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonAboutUiModel
import com.vinicius.pokemondetail.R
import com.vinicius.pokemondetail.databinding.PokemonAboutFragmentBinding

private const val POKEMON = "POKEMON"

class PokemonAboutFragment : BaseFragment() {
    private var pokemon: PokemonAboutUiModel? = null

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

    private fun setupView(pokemon: PokemonAboutUiModel?) = with(binding) {
        pokemon?.apply {
            tvAboutDescription.text = description
            tvPokedexDataTitle.setTextColor(baseColor)
            tvSpeciesLabel.text = species
            tvHeightLabel.text = getString(R.string.frag_poke_about_height_label, height)
            tvWeightLabel.text = getString(R.string.frag_poke_about_weight_label, weight)
            tvTrainingTitle.setTextColor(baseColor)
            tvEvyieldLabel.text = evYield
            tvCatchRateLabel.text = getString(
                R.string.frag_poke_about_catch_rate_label,
                catchRate?.value, catchRate?.text
            )
            tvBaseFriendshipLabel.text = getString(
                R.string.frag_poke_about_base_friendship_label,
                baseFriendship?.value, baseFriendship?.text
            )
            tvBaseExpLabel.text = pokemon.baseExp
            tvGrowthRateLabel.text = growthRate
            tvBreedingTitle.setTextColor(baseColor)
            tvGenderLabel.text = getFormattedGenderLabel(male, female)
            tvEggGroupsLabel.text = eggGroups
            tvEggCyclesLabel.text = getString(
                R.string.frag_poke_about_egg_cycles_label,
                eggCycles?.value, eggCycles?.text
            )
        }
    }

    private fun getFormattedGenderLabel(male: Double?, female: Double?): SpannableStringBuilder {
        return SpannableStringBuilder()
            .color(ContextCompat.getColor(requireContext(), R.color.gender_male)) {
                append(getString(R.string.frag_poke_about_gender_male_label, male))
            }
            .append(", ")
            .color(ContextCompat.getColor(requireContext(), R.color.gender_female)) {
                append(getString(R.string.frag_poke_about_gender_female_label, female))
            }
    }

    companion object {
        fun newInstance(pokemon: PokemonAboutUiModel?) =
            PokemonAboutFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(POKEMON, pokemon)
                }
            }
    }
}