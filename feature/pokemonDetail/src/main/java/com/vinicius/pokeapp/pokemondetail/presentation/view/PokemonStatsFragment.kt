package com.vinicius.pokeapp.pokemondetail.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vinicius.pokeapp.core.views.BaseFragment
import com.vinicius.pokeapp.pokemondetail.presentation.adapter.PokemonAttributesAdapter
import com.vinicius.pokeapp.pokemondetail.presentation.adapter.PokemonTypeDefenseAdapter
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonStatsUiModel
import com.vinicius.pokemondetail.R
import com.vinicius.pokemondetail.databinding.PokemonStatsFragmentBinding

private const val POKEMON_NAME = "POKEMON_NAME"
private const val POKEMON_STATS = "POKEMON_STATS"

class PokemonStatsFragment : BaseFragment() {
    private var pokemonName: String = ""
    private var pokemonStatsModel: PokemonStatsUiModel? = null
    private lateinit var pokemonAttributesAdapter: PokemonAttributesAdapter
    private val pokemonTypeDefensesAdapter: PokemonTypeDefenseAdapter by lazy {
        PokemonTypeDefenseAdapter()
    }

    private lateinit var binding: PokemonStatsFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pokemonName = it.getString(POKEMON_NAME).toString()
            pokemonStatsModel = it.getParcelable(POKEMON_STATS)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PokemonStatsFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() = with(binding) {
        pokemonStatsModel?.let { pokemonStatsModel ->
            updateContent(pokemonStatsModel)
            setupAttributesAdapter(pokemonStatsModel)
            setupTypeDefensesAdapter(pokemonStatsModel)
        }
        tvPokedexTypeDefensesLabel.text = getString(
            R.string.frag_poke_stats_type_defenses_label,
            pokemonName
        )
    }

    private fun PokemonStatsFragmentBinding.updateContent(
        pokemonStatsModel: PokemonStatsUiModel
    ) {
        tvPokedexBaseStatsTitle.setTextColor(pokemonStatsModel.baseColor)
        tvPokedexTypeDefensesTitle.setTextColor(pokemonStatsModel.baseColor)
    }

    private fun PokemonStatsFragmentBinding.setupTypeDefensesAdapter(
        pokemonStatsModel: PokemonStatsUiModel
    ) {
        pokemonTypeDefensesAdapter.submitList(pokemonStatsModel.typeDefenses)
        rvTypeDefenses.adapter = pokemonTypeDefensesAdapter
    }

    private fun PokemonStatsFragmentBinding.setupAttributesAdapter(
        pokemonStatsModel: PokemonStatsUiModel
    ) {
        pokemonAttributesAdapter = PokemonAttributesAdapter(
            pokemonStatsModel.baseColor
        )
        pokemonAttributesAdapter.submitList(pokemonStatsModel.attributes)
        rvAttributes.adapter = pokemonAttributesAdapter
    }

    companion object {
        fun newInstance(pokemonName: String, pokemon: PokemonStatsUiModel?) =
            PokemonStatsFragment().apply {
                arguments = Bundle().apply {
                    putString(POKEMON_NAME, pokemonName)
                    putParcelable(POKEMON_STATS, pokemon)
                }
            }
    }
}