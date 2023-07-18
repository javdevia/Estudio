package com.example.appyoutubearis.SuperHeroList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appyoutubearis.R

class DetailSuperheroActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_superhero)
    }
}