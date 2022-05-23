package com.vinicius.pokeapp.pokemondetail.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonAttributesUiModel
import com.vinicius.pokemondetail.databinding.PokemonAttributesItemBinding

class PokemonAttributesAdapter(
    private val baseColor: Int
) : ListAdapter<PokemonAttributesUiModel, PokemonAttributesAdapter.ViewHolder>(
    PokemonAttributesDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            PokemonAttributesItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemCount(): Int = currentList.size

    inner class ViewHolder(val binding: PokemonAttributesItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(attributes: PokemonAttributesUiModel) {
            binding.baseColor = baseColor
            binding.attribute = attributes
        }
    }
}

class PokemonAttributesDiffCallback : DiffUtil.ItemCallback<PokemonAttributesUiModel>() {

    override fun areItemsTheSame(
        oldItem: PokemonAttributesUiModel,
        newItem: PokemonAttributesUiModel
    ): Boolean = oldItem.attributeName == newItem.attributeName

    override fun areContentsTheSame(
        oldItem: PokemonAttributesUiModel,
        newItem: PokemonAttributesUiModel
    ): Boolean = oldItem == newItem
}