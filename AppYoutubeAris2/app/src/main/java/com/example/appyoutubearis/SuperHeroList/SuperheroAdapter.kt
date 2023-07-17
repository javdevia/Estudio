package com.example.appyoutubearis.SuperHeroList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appyoutubearis.R

class SuperheroAdapter(var superheroList: List<SuperheroItemResponse> = emptyList()) :
    RecyclerView.Adapter<SuperheroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        return SuperheroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
    }

    override fun getItemCount() = superheroList.size

    override fun onBindViewHolder(viewholder: SuperheroViewHolder, position: Int) {
        viewholder.bind(superheroList[position])
    }
}