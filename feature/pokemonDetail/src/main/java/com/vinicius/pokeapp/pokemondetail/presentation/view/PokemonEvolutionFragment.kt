package com.vinicius.pokeapp.pokemondetail.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vinicius.pokeapp.core.views.BaseFragment
import com.vinicius.pokemondetail.databinding.PokemonEvolutionFragmentBinding

private const val POKEMON_ID = "POKEMON_ID"

class PokemonEvolutionFragment : BaseFragment() {
    private var pokemonId: Int = -1

    private lateinit var binding: PokemonEvolutionFragmentBinding
    private val viewModel by lazy { getViewModel(PokemonEvolutionViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pokemonId = it.getString(POKEMON_ID)?.toInt() ?: -1
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PokemonEvolutionFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeChanges()
        viewModel.dispatchViewAction(PokemonEvolutionViewAction.GetPokemonSpecie(pokemonId))
    }

    private fun observeChanges() {
        viewModel.viewState.pokemonLiveData.observe(viewLifecycleOwner) {
            it?.let { pokemonUiModel ->
                binding.tvEvolution.text = pokemonUiModel.evolutionChainId.toString()
            }
        }
    }

    companion object {
        fun newInstance(pokemonId: String) =
            PokemonEvolutionFragment().apply {
                arguments = Bundle().apply {
                    putString(POKEMON_ID, pokemonId)
                }
            }
    }
}