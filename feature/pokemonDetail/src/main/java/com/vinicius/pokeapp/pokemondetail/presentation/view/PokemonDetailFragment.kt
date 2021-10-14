package com.vinicius.pokeapp.pokemondetail.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.vinicius.pokeapp.core.views.BaseFragment
import com.vinicius.pokeapp.pokemondetail.presentation.adapter.PokemonDetailPagerAdapter
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonDetailUiModel
import com.vinicius.pokemondetail.databinding.PokemonDetailFragmentBinding

private const val POKEMON_ID = "POKEMON_ID"

class PokemonDetailFragment : BaseFragment() {

    private lateinit var adapter: PokemonDetailPagerAdapter

    private lateinit var binding: PokemonDetailFragmentBinding
    private val viewModel by lazy { getViewModel(PokemonDetailViewModel::class.java) }

    private val pagesTitles = listOf("About", "Stats", "Evolution")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            viewModel.dispatchViewAction(PokemonDetailViewAction.GetPokemonById(it.getInt(POKEMON_ID)))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PokemonDetailFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeChanges()

        binding.toolbar.backButton.setOnClickListener {
            activity?.onBackPressed()
        }


    }

    private fun observeChanges() {
        viewModel.viewState.pokemonLiveData.observe(viewLifecycleOwner, {
            it?.let { pokemonUiModel ->
                binding.pokemon = pokemonUiModel
                setupViewPager(pokemonUiModel)
            }
        })
    }

    private fun setupViewPager(pokemonUiModel: PokemonDetailUiModel) {
        adapter = PokemonDetailPagerAdapter(requireActivity(), pagesTitles)
        adapter.updatePokemon(pokemonUiModel)
        binding.vpPokemonDetail.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.vpPokemonDetail) { tab, position ->
            tab.text = pagesTitles[position]
        }.attach()
    }

    companion object {
        fun newInstance(pokemonId: Int): PokemonDetailFragment {
            return PokemonDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(POKEMON_ID, pokemonId)
                }
            }
        }
    }

}