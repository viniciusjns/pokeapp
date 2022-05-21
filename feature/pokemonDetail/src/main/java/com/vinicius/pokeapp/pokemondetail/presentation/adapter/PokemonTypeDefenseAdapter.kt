package com.vinicius.pokeapp.pokemondetail.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vinicius.pokeapp.pokemondetail.presentation.model.TypeDefense
import com.vinicius.pokemondetail.databinding.PokemonTypeDefenseItemBinding

class PokemonTypeDefenseAdapter(
    private val typeDefenses: List<Pair<TypeDefense, String?>>
) : RecyclerView.Adapter<PokemonTypeDefenseAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PokemonTypeDefenseItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(typeDefenses[position])
    }

    override fun getItemCount(): Int = typeDefenses.size

    inner class ViewHolder(val binding: PokemonTypeDefenseItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(typeDefense: Pair<TypeDefense, String?>) {
            Glide.with(binding.root.context).load(typeDefense.first.icon).into(binding.ivTypeDefense)
            binding.tvTypeDefenseLabel.text = typeDefense.second
        }
    }
}