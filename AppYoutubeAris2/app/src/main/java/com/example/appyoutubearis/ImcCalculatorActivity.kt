package com.example.appyoutubearis

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private lateinit var cvMale: CardView
    private lateinit var cvFemale: CardView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvHeight: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        cvMale = findViewById(R.id.cvMale)
        cvFemale = findViewById(R.id.cvFemale)
        rsHeight = findViewById(R.id.rsHight)
        tvHeight = findViewById(R.id.tvHeight)
    }

    @SuppressLint("SetTextI18n")
    private fun initListeners() {
        cvMale.setOnClickListener {
            isMaleSelected = true
            isFemaleSelected = false
            setGenderColor()
        }
        cvFemale.setOnClickListener {
            isMaleSelected = false
            isFemaleSelected = true
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            val result = df.format(value)
            tvHeight.text = "$result cm"
        }

    }

    private fun setGenderColor() {
        cvMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        cvFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {

        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
    }
}