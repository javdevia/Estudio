package com.example.appyoutubearis.SaludApp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appyoutubearis.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvResult = findViewById<TextView>(R.id.saludo)
        val name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()
        tvResult.text = "Hola $name"
    }
}