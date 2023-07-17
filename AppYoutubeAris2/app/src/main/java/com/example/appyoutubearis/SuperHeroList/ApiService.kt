package com.example.appyoutubearis.SuperHeroList

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("api/10160891802034248/search/{name}")
    suspend fun getSuperheroes (@Path("name") superheroName:String): Response<SuperheroDataResponse>

}