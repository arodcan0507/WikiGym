package com.example.wikigym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.wikigym.databinding.ActivityImcBinding
import java.text.DecimalFormat
import kotlin.math.roundToInt

class IMCActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "IMC"

        configureNumberPicker()

        binding.butCalcIMC.setOnClickListener {
            calcIMC()
        }
    }
    fun configureNumberPicker() {
        var minAltura = 65
        var maxAltura = 246
        var minPeso = 50
        var maxPeso = 180

        binding.NPAltura.minValue = minAltura
        binding.NPAltura.maxValue = maxAltura

        binding.NPPeso.minValue = minPeso
        binding.NPPeso.maxValue = maxPeso
    }
    fun calcIMC() {
        var multi = 0.01
       val height = binding.NPAltura.value * multi
       val weight = binding.NPPeso.value

       val df = DecimalFormat("0.00")
       val imc = (weight / (height * height))
       val result = df.format(imc)
       Toast.makeText(this, imc.toString(), Toast.LENGTH_SHORT).show()

       val intent = Intent(this,IMCResultadoActivity::class.java)
        intent.putExtra("IMC", result.toString())
        startActivity(intent)
    }
}