package com.vinicius.pokeapp.pokemonlist.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vinicius.pokeapp.core.extensions.capitalize
import com.vinicius.pokeapp.core.extensions.loadImage
import com.vinicius.pokeapp.core.extensions.setIcon
import com.vinicius.pokeapp.core.extensions.tintBackground
import com.vinicius.pokeapp.pokemonlist.presentation.model.PokemonListUiModel
import com.vinicius.pokemonlist.databinding.PokemonListItemBinding

class PokemonListAdapter(
    private val showPokemonDetail: (PokemonListUiModel) -> Unit
) : ListAdapter<PokemonListUiModel, PokemonListAdapter.ViewHolder>(PokemonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PokemonListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = currentList[position]
        holder.onBind(pokemon)
    }

    override fun getItemCount(): Int = currentList.size

    inner class ViewHolder(
        private val binding: PokemonListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(pokemon: PokemonListUiModel) = with(binding) {
            flContainer.tintBackground(pokemon.bgColor)
            ivPicture.loadImage(pokemon.imageUrl)
            tvNumber.text = pokemon.getNumber()
            tvName.capitalize(pokemon.name)
            with(layoutType1) {
                container.tintBackground(pokemon.typeColors?.get(0))
                ivIcon.setIcon(pokemon.types?.get(0))
                tvType.capitalize(pokemon.types?.get(0))
            }
            with(layoutType2) {
                container.isVisible = pokemon.canShowSecondType
                if (pokemon.canShowSecondType) {
                    container.tintBackground(pokemon.typeColors?.get(1))
                    ivIcon.setIcon(pokemon.types?.get(1))
                    tvType.capitalize(pokemon.types?.get(1))
                }
            }

            root.setOnClickListener {
                showPokemonDetail(pokemon)
            }
        }
    }
}

class PokemonDiffCallback : DiffUtil.ItemCallback<PokemonListUiModel>() {

    override fun areItemsTheSame(
        oldItem: PokemonListUiModel,
        newItem: PokemonListUiModel
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: PokemonListUiModel,
        newItem: PokemonListUiModel
    ): Boolean = oldItem == newItem
}