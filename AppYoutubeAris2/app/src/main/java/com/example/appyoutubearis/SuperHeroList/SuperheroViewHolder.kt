package com.example.appyoutubearis.SuperHeroList

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.appyoutubearis.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)
    fun bind(superheroItemResponse: SuperheroItemResponse, onItemSelected: (String) -> Unit) {
        binding.tvSuperheroName.text = superheroItemResponse.SuperheroName
        Picasso.get().load(superheroItemResponse.SuperheroImage.url).into(binding.ivSuperheroImage)
        binding.root.setOnClickListener {
            onItemSelected(superheroItemResponse.SuperheroId)
        }
    }
}