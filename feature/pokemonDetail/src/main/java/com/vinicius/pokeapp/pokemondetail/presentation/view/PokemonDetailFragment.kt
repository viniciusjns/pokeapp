package com.vinicius.pokeapp.pokemondetail.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.google.android.material.tabs.TabLayoutMediator
import com.vinicius.pokeapp.core.extensions.capitalize
import com.vinicius.pokeapp.core.extensions.loadImage
import com.vinicius.pokeapp.core.extensions.setIcon
import com.vinicius.pokeapp.core.extensions.tintBackground
import com.vinicius.pokeapp.core.views.BaseFragment
import com.vinicius.pokeapp.pokemondetail.presentation.adapter.PokemonDetailPagerAdapter
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonDetailUiModel
import com.vinicius.pokemondetail.databinding.PokemonDetailFragmentBinding

private const val POKEMON_ID = "POKEMON_ID"

class PokemonDetailFragment : BaseFragment() {

    private val adapter: PokemonDetailPagerAdapter by lazy {
        PokemonDetailPagerAdapter(requireActivity(), pagesTitles)
    }
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
        viewModel.viewState.pokemonLiveData.observe(viewLifecycleOwner) {
            it?.let { pokemonUiModel ->
                setupView(pokemonUiModel)
                setupViewPager(pokemonUiModel)
            }
        }
    }

    private fun setupView(pokemonUiModel: PokemonDetailUiModel) = with(binding) {
        pokemonUiModel.apply {
            clContainer.tintBackground(bgColor)
            tvNameBackground.text = name
            ivPicture.loadImage(imageUrl)
            tvNumber.text = getNumber()
            tvName.capitalize(name)
            with(layoutType1) {
                container.tintBackground(typeColors?.get(0))
                ivIcon.setIcon(types?.get(0))
                tvType.capitalize(types?.get(0))
            }
            with(layoutType2) {
                container.isVisible = canShowSecondType
                if (canShowSecondType) {
                    container.tintBackground(typeColors?.get(1))
                    ivIcon.setIcon(types?.get(1))
                    tvType.capitalize(types?.get(1))
                }
            }
        }
    }

    private fun setupViewPager(pokemonUiModel: PokemonDetailUiModel) {
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