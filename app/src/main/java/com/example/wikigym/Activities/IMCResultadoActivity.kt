package com.example.wikigym

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wikigym.databinding.ActivityImcresultadoBinding

class IMCResultadoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImcresultadoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcresultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "IMC Resultado"

        val result = intent.getStringExtra("IMC")?.toDouble()
        binding.tvResultado.text = result.toString()

        configureColors(result)
    }
    fun configureColors(result: Double?) {
        var rango1 = 18.5
        var rango2 = 24.9
        var rango3 = 29.9
        var rango4 = 34.9
        var rango5 = 39.9

        if (result!! <= rango1) {
            binding.tvResultado.setTextColor(resources.getColor(R.color.lightBlue))
            binding.tvDesc.text = resources.getString(R.string.mensaje)
        } else if (result!! <= rango2) {
            binding.tvResultado.setTextColor(resources.getColor(R.color.lightGreen))
            binding.tvDesc.text = resources.getString(R.string.mensaje2)
        } else if (result!! <= rango3) {
            binding.tvResultado.setTextColor(resources.getColor(R.color.lightYellow))
            binding.tvDesc.text = resources.getString(R.string.mensaje3)
        } else if (result!! <= rango4) {
            binding.tvResultado.setTextColor(resources.getColor(R.color.lightOrange))
            binding.tvDesc.text = resources.getString(R.string.mensaje4)
        } else if (result!! <= rango5) {
            binding.tvResultado.setTextColor(resources.getColor(R.color.lightRed))
            binding.tvDesc.text = resources.getString(R.string.mensaje5)
        } else {
            binding.tvResultado.setTextColor(resources.getColor(R.color.lightPurple))
            binding.tvDesc.text = resources.getString(R.string.mensaje6)
        }
    }
}