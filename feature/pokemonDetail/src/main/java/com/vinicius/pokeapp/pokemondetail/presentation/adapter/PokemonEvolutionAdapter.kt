package com.vinicius.pokeapp.pokemondetail.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vinicius.pokeapp.core.extensions.capitalize
import com.vinicius.pokeapp.core.extensions.loadImage
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonEvolutionChainUiModel
import com.vinicius.pokemondetail.R
import com.vinicius.pokemondetail.databinding.PokemonEvolutionItemBinding

class PokemonEvolutionAdapter : ListAdapter<PokemonEvolutionChainUiModel, PokemonEvolutionAdapter.ViewHolder>(
    PokemonEvolutionDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            PokemonEvolutionItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class ViewHolder(private val binding: PokemonEvolutionItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(pokemonEvolutionChainUiModel: PokemonEvolutionChainUiModel) = with(binding) {
            ivBasePokemonImage.loadImage(pokemonEvolutionChainUiModel.basePokemonImageUrl)
            tvBasePokemonName.capitalize(pokemonEvolutionChainUiModel.nameBasePokemon)
            tvLevel.text = if (pokemonEvolutionChainUiModel.levelToEvolve != null) {
                root.context.getString(R.string.frag_evolution_level_to_evolve, pokemonEvolutionChainUiModel.levelToEvolve)
            } else {
                root.context.getString(R.string.frag_evolution_level_not_found)
            }
            ivEvolvedPokemonImage.loadImage(pokemonEvolutionChainUiModel.evolvedPokemonImageUrl)
            tvEvolvedPokemonName.capitalize(pokemonEvolutionChainUiModel.nameEvolvedPokemon)
        }
    }
}

class PokemonEvolutionDiffCallback : DiffUtil.ItemCallback<PokemonEvolutionChainUiModel>() {
    override fun areItemsTheSame(
        oldItem: PokemonEvolutionChainUiModel,
        newItem: PokemonEvolutionChainUiModel
    ): Boolean = oldItem.idBasePokemon == newItem.idBasePokemon

    override fun areContentsTheSame(
        oldItem: PokemonEvolutionChainUiModel,
        newItem: PokemonEvolutionChainUiModel
    ): Boolean = oldItem == newItem

}