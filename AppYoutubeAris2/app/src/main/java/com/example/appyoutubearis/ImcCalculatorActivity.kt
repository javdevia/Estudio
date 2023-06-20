package com.example.appyoutubearis

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var weight: Int = 60
    private var age: Int = 25

    private lateinit var cvMale: CardView

    private lateinit var cvFemale: CardView

    private lateinit var rsHeight: RangeSlider
    private lateinit var tvHeight: TextView

    private lateinit var fabWeightSubtract: FloatingActionButton
    private lateinit var fabWeightAdd: FloatingActionButton
    private lateinit var tvWeight: TextView

    private lateinit var fabAgeSubtract: FloatingActionButton
    private lateinit var fabAgeAdd: FloatingActionButton
    private lateinit var tvAge: TextView


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
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHight)

        fabWeightSubtract = findViewById(R.id.fabWeightSubtract)
        fabWeightAdd = findViewById(R.id.fabWeightAdd)
        tvWeight = findViewById(R.id.tvWeight)

        fabAgeSubtract = findViewById(R.id.fabAgeSubtract)
        fabAgeAdd = findViewById(R.id.fabAgeAdd)
        tvAge = findViewById(R.id.tvAge)
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

        fabWeightSubtract.setOnClickListener {
            weight -= 1
            tvWeight.text = "$weight kg"
        }

        fabWeightAdd.setOnClickListener {
            weight += 1
            tvWeight.text = "$weight kg"
        }

         fabAgeSubtract.setOnClickListener {
            age -= 1
            tvAge.text = age.toString()
        }

        fabAgeAdd.setOnClickListener {
            age += 1
            tvAge.text = age.toString()
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