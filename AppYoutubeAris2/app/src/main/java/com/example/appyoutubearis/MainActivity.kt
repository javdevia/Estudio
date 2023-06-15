package com.example.appyoutubearis

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inicializacion de graficos
        val btnAcceptName = findViewById<AppCompatButton>(R.id.btnAcceptName)
        val etName = findViewById<AppCompatEditText>(R.id.etName)

        //Observadores
        btnAcceptName.setOnClickListener {
            val name: String = etName.text.toString()
            if (name.isNotEmpty()) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            }
        }

    }
}