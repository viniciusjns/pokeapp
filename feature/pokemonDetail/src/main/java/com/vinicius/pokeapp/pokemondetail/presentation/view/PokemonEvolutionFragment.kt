package com.vinicius.pokeapp.pokemondetail.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vinicius.pokeapp.core.views.BaseFragment
import com.vinicius.pokeapp.pokemondetail.presentation.adapter.PokemonEvolutionAdapter
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonDetailUiModel
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonEvolutionUiModel
import com.vinicius.pokemondetail.databinding.PokemonEvolutionFragmentBinding

private const val POKEMON = "POKEMON"

class PokemonEvolutionFragment : BaseFragment() {

    private var pokemon: PokemonEvolutionUiModel? = null
    private lateinit var binding: PokemonEvolutionFragmentBinding
    private val viewModel by lazy { getViewModel(PokemonEvolutionViewModel::class.java) }
    private val adapter: PokemonEvolutionAdapter by lazy {
        PokemonEvolutionAdapter()
    }

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
        binding = PokemonEvolutionFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeChanges()
        setupView()
        viewModel.dispatchViewAction(
            PokemonEvolutionViewAction.GetPokemonSpecie(pokemon?.id ?: 0)
        )
    }

    private fun setupView() = with(binding) {
        rvEvolution.adapter = adapter
        pokemon?.let {
            tvEvolutionTitle.setTextColor(it.baseColor)
        }
    }

    private fun observeChanges() {
        viewModel.viewState.pokemonLiveData.observe(viewLifecycleOwner) {
            it?.let { pokemonUiModel ->
                adapter.submitList(pokemonUiModel)
            }
        }
    }

    companion object {
        fun newInstance(pokemon: PokemonEvolutionUiModel) =
            PokemonEvolutionFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(POKEMON, pokemon)
                }
            }
    }
}