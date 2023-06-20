package com.example.appyoutubearis

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appyoutubearis.ImcCalculatorActivity.Companion.IMC_KEY

class imcResultActivity : AppCompatActivity() {

    private lateinit var tvResultImc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_result)

        initComponents()
        initUI()
    }

    private fun initComponents() {
        tvResultImc = findViewById(R.id.tvResultImc)
    }

    private fun initUI() {
        tvResultImc.text = getImc()
    }

    private fun getImc(): String {
        val imcFinal = intent.extras?.getString(IMC_KEY).orEmpty()
        return imcFinal
    }

}