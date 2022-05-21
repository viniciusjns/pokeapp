package com.vinicius.pokeapp.pokemondetail.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonAttributesUiModel
import com.vinicius.pokemondetail.databinding.PokemonAttributesItemBinding

class PokemonAttributesAdapter(
    private val baseColor: Int,
    private val attributes: List<PokemonAttributesUiModel>
) : RecyclerView.Adapter<PokemonAttributesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            PokemonAttributesItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(attributes[position])
    }

    override fun getItemCount(): Int = attributes.size

    inner class ViewHolder(val binding: PokemonAttributesItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(attributes: PokemonAttributesUiModel) {
            binding.baseColor = baseColor
            binding.attribute = attributes
        }
    }
}