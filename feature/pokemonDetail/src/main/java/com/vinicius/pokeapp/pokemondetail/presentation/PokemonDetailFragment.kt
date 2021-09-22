package com.vinicius.pokeapp.pokemondetail.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.vinicius.pokeapp.core.views.BaseFragment
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonDetailUiModel
import com.vinicius.pokemondetail.databinding.PokemonDetailFragmentBinding

private const val POKEMON_ID = "POKEMON_ID"

class PokemonDetailFragment : BaseFragment() {

    private var pokemon: PokemonDetailUiModel? = null

    private lateinit var binding: PokemonDetailFragmentBinding
    private val viewModel by lazy { getViewModel(PokemonDetailViewModel::class.java) }

    private val infoTitles = listOf("About", "Stats", "Evolution")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            viewModel.getPokemonById(it.getInt(POKEMON_ID))
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

        binding.toolbar.backButton.setOnClickListener {
            activity?.onBackPressed()
        }

        val adapter = PokemonDetailPagerAdapter(requireActivity())
        binding.vpPokemonDetail.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.vpPokemonDetail) { tab, position ->
            tab.text = infoTitles[position]
        }.attach()

        observeChanges()
    }

    private fun observeChanges() {
        viewModel.pokemonDetailLiveData.observe(viewLifecycleOwner, {
            binding.pokemon = it
            this.pokemon = it
        })
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

    private inner class PokemonDetailPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

        override fun getItemCount() = infoTitles.size

        override fun createFragment(position: Int): Fragment =
            when (position) {
                0 -> PokemonAboutFragment.newInstance(pokemon?.pokemonAboutModel, pokemon?.getTypeColor())
                1 -> PokemonStatsFragment.newInstance(pokemon?.pokemonStatsModel, pokemon?.getTypeColor())
                2 -> PokemonEvolutionFragment.newInstance(pokemon?.pokemonEvolutionModel, pokemon?.getTypeColor())
                else -> PokemonAboutFragment.newInstance(pokemon?.pokemonAboutModel, pokemon?.getTypeColor())
            }

    }

}