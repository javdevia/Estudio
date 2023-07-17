package com.example.appyoutubearis.SuperHeroList

import com.google.gson.annotations.SerializedName

data class SuperheroDataResponse (@SerializedName("response") val response:String,
@SerializedName ("results") val superheroes: List<>)