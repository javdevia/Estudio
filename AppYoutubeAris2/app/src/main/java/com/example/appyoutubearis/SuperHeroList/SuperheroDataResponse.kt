package com.example.appyoutubearis.SuperHeroList

import com.google.gson.annotations.SerializedName

data class SuperheroDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val superheroes: List<SuperheroItemResponse>
)

data class SuperheroItemResponse(
    @SerializedName("id") val SuperheroId:String,
    @SerializedName("name") val SuperheroName:String,
    @SerializedName("image") val SuperheroImage: SuperheroImageResponse
)

data class SuperheroImageResponse (
    @SerializedName("url") val url:String
        )