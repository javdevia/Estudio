package com.example.appyoutubearis

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appyoutubearis.ImcCalculatorActivity.Companion.IMC_KEY
import java.text.DecimalFormat

class imcResultActivity : AppCompatActivity() {


    private lateinit var tvResultEvaluation: TextView
    private lateinit var tvResultImc: TextView
    private lateinit var tvResultDetail: TextView
    private lateinit var btnReCalculate: Button
    private var IMC = 20.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_result)
        IMC = getImc()
        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        tvResultEvaluation = findViewById(R.id.tvResultEvaluation)
        tvResultImc = findViewById(R.id.tvResultImc)
        tvResultDetail = findViewById(R.id.tvResultDetail)
        btnReCalculate = findViewById(R.id.btnReCalculate)
    }

    private fun initListeners() {
        btnReCalculate.setOnClickListener {
            intent = Intent(this, ImcCalculatorActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initUI() {
        tvResultEvaluation.text = getEvaluation(IMC)
        tvResultImc.text = roundIMC()
        tvResultDetail.text = getDetail(IMC)
    }

    private fun getDetail(IMC: Double): String {
        val evaluation: String = when (IMC) {
            in 0.00..18.49 -> "Tu índice de masa corporal está un poco bajo"
            in 18.50..24.99 -> "Tu índice de masa corporal está Normal"
            in 25.00..29.99 -> "Tu índice de masa corporal está un poco Alto"
            in 30.00..100.00 -> "Tu índice demasa corporal está demasiado algo"
            else -> "Error"
        }
        return evaluation
    }

    private fun getEvaluation(IMC: Double): String {
        val evaluation: String = when (IMC) {
            in 0.00..18.49 -> "Bajo"
            in 18.50..24.99 -> "Normal"
            in 25.00..29.99 -> "Alto"
            in 30.00..100.00 -> "Obesidad"
            else -> "Error"
        }
        return evaluation
    }

    private fun getImc(): Double {
        val imcFinal = intent.extras?.getDouble(IMC_KEY) ?: 0.00
        return imcFinal
    }

    private fun roundIMC(): String {
        val roundImc = getImc()
        val df = DecimalFormat("#.##")
        val roundedImcString = df.format(roundImc)
        return roundedImcString
    }
}