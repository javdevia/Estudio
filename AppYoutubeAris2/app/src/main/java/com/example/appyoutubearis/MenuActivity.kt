package com.example.appyoutubearis

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Inicialización de botones
        val btnSaludapp = findViewById<Button>(R.id.btnSaludapp)
        val btnImcCalculator = findViewById<Button>(R.id.btnImcCalculator)
        val btnToDoApp = findViewById<Button>(R.id.btnToDoApp)

        // Observadores de botones
        btnSaludapp.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnImcCalculator.setOnClickListener {
            val intent = Intent(this, ImcCalculatorActivity::class.java)
            startActivity(intent)
        }

        btnToDoApp.setOnClickListener {
            val intent = Intent (this,ToDoAppActivity::class.java)
            startActivity(intent)
        }
    }
}