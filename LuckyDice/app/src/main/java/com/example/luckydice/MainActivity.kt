package com.example.luckydice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main() {
    val myFirstDice = Dice(6)
    val rollResult = myFirstDice.roll()
    println("Your ${myFirstDice.numSides} sided dice rolled ${rollResult}!")
}

class Dice (val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}