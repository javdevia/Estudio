package com.example.appyoutubearis.Menu

import com.example.appyoutubearis.ImcCalculator.ImcCalculatorActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.appyoutubearis.SaludApp.MainActivity
import com.example.appyoutubearis.R
import com.example.appyoutubearis.SuperHeroList.SuperheroListActivity
import com.example.appyoutubearis.ToDoApp.ToDoAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Inicialización de botones
        val btnSaludapp = findViewById<Button>(R.id.btnSaludapp)
        val btnImcCalculator = findViewById<Button>(R.id.btnImcCalculator)
        val btnToDoApp = findViewById<Button>(R.id.btnToDoApp)
        val btnSuperheroList = findViewById<Button>(R.id.btnSuperheroList)

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
            val intent = Intent (this, ToDoAppActivity::class.java)
            startActivity(intent)
        }

        btnSuperheroList.setOnClickListener {
            val intent = Intent (this, SuperheroListActivity::class.java)
            startActivity(intent)
        }
    }
}