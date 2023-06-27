package com.example.appyoutubearis.ImcCalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.appyoutubearis.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat


class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var actualHeight: Int = 100
    private var actualWeight: Int = 60
    private var actualAge: Int = 25


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

    private lateinit var btnCalculate: Button

    companion object {
        const val IMC_KEY = "EXTRA_IMC"
    }

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

        btnCalculate = findViewById(R.id.btnCalculate)
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
            actualHeight = result.toInt()
        }

        fabWeightSubtract.setOnClickListener {
            actualWeight -= 1
            tvWeight.text = "$actualWeight kg"
        }

        fabWeightAdd.setOnClickListener {
            actualWeight += 1
            tvWeight.text = "$actualWeight kg"
        }

        fabAgeSubtract.setOnClickListener {
            actualAge -= 1
            tvAge.text = actualAge.toString()
        }

        fabAgeAdd.setOnClickListener {
            actualAge += 1
            tvAge.text = actualAge.toString()
        }

        btnCalculate.setOnClickListener {
            val result = calculateImc()
            showResult(result)
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

    private fun calculateImc():Double {
        val df = DecimalFormat("#.##")
        val weight:Double = actualWeight.toDouble()
        val height:Double = actualHeight.toDouble()

        val imc:Double = weight/(height/100*height/100)
        //return df.format(imc)
        return imc
    }

    private fun showResult(result: Double) {
        val intent2 = Intent(this, imcResultActivity::class.java)
        intent2.putExtra(IMC_KEY, result)
        startActivity(intent2)
    }
}

