package com.vinicius.pokeapp.pokemonlist.view.adapters

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.vinicius.pokeapp.service.response.Pokemon
import com.vinicius.pokemonlist.databinding.PokemonListItemBinding

class PokemonListAdapter(
    val pokemonList: List<Pokemon>
) : RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PokemonListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.onBind(pokemon)
    }

    override fun getItemCount(): Int = pokemonList.size

    inner class ViewHolder(
        private val binding: PokemonListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(pokemon: Pokemon) {
            binding.tvNumber.text = pokemon.getNumber()
            binding.tvName.text = pokemon.getCapsName()

            Glide.with(binding.root)
                .load(pokemon.getImageUrl())
                .listener(
                    GlidePalette.with(pokemon.getImageUrl())
                        .use(BitmapPalette.Profile.MUTED_LIGHT)
                        .intoCallBack { palette ->
                            val rgb = palette?.dominantSwatch?.rgb
                            if (rgb != null) {
                                binding.flContainer.backgroundTintList = ColorStateList.valueOf(rgb)
                            }
                        }.crossfade(true)
                ).into(binding.ivPicture)
        }

    }

}