package com.example.appyoutubearis.SuperHeroList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.appyoutubearis.databinding.ActivitySuperheroListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperheroListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperheroListBinding
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperheroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        binding.svName.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
            }

            override fun onQueryTextChange(newText: String?) = false
        })
    }

    private fun searchByName(query: String) {
        CoroutineScope(Dispatchers.IO).launch{
        val myResponse = retrofit.create(ApiService::class.java).getSuperheroes(query)
            val response = myResponse.body()
            if (response!=null){

            }
        }

    }

    private fun getRetrofit(): Retrofit {
         return Retrofit
             .Builder()
             .baseUrl("https://superheroapi.com/api/10160891802034248/")
             .addConverterFactory(GsonConverterFactory.create())
             .build()
    }

}