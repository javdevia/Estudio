package com.example.pinguino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.pinguino.R

/**
 * Esta actividad permite al usuario lanzar un dado y ver el resultado en la pantalla.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {

            rollButton.setOnClickListener { rollDice() }

        }
        // Tira un dado al comenzar la aplicación
        rollDice()
    }

    /**
     *  Tira el dado y actualiza la pantalla con su resultado
     */

    private fun rollDice() {
        // Crea el primer dado de los lados indicados y lo lanza
        val dice = Dice(4)
        val diceRoll = dice.roll()

        // Busca la imagen en la pantalla
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Selecciona la imagen a utilizar para el resultado
        val drawableResource = when (diceRoll){
            1 -> R.drawable.ruleta_1
            2 -> R.drawable.ruleta_2
            3 -> R.drawable.ruleta_3
            else -> R.drawable.ruleta_4

        }

        // Dibuja la imagen selccionada
        diceImage.setImageResource(drawableResource)

        // Actualiza el valor de la imagen
        diceImage.contentDescription = diceRoll.toString()

    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}