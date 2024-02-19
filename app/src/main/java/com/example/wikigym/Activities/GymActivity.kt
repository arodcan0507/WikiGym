package com.example.wikigym.Activities

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.wikigym.Clases.Utilidades
import com.example.wikigym.R
import com.example.wikigym.databinding.ActivityGymBinding

class GymActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGymBinding
    private var boolSearchGym: Boolean = false
    private var nombreGym: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGymBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar()
        configureMACTextView()

        binding.butSearchGym.setOnClickListener {
            searchGym()
        }
        binding.cbApuntado.setOnCheckedChangeListener { buttonView, isChecked ->
            clickCheckBox(isChecked)
        }
        binding.tbLike.setOnCheckedChangeListener { _, isChecked ->
            clickToggleButton(isChecked)
        }
        binding.switchAntes.setOnCheckedChangeListener { _, isChecked ->
            clickSwitch(isChecked)
        }
        binding.fabNavDetailGym.setOnClickListener {
            navDetailGym(boolSearchGym)
        }
        binding.butSavePaises.setOnClickListener {
            Utilidades.animarViewOfInt(binding.butSavePaises,"backgroundColor", ContextCompat.getColor(this,
                R.color.green
            ),1000)
            val message = "Cuidades guardadas con éxito"
            Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
        }
    }
    fun navDetailGym(search: Boolean) {
        var message = ""
        if (search) {
            message = "Navegando a detalle de ${nombreGym}"
            val intent = Intent(this, GymDetailActivity::class.java)
            intent.putExtra("nombreGym", nombreGym)
            startActivity(intent)
        } else {
            message = "Primero debes seleccionar un Gym válido"
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    fun configureActionBar() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "GYM"
    }
    fun configureMACTextView() {
        val gyms = resources.getStringArray(R.array.gimnasios)
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,gyms)
        binding.mactvGimnasios.setAdapter(adapter)

        val cuidades = resources.getStringArray(R.array.cuidades)
        val adapterCuidades = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,cuidades)
        binding.MACTVPaises.setAdapter(adapterCuidades)
        binding.MACTVPaises.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
    }
    fun searchGym() {
        val gyms = resources.getStringArray(R.array.gimnasios)
        val text = binding.mactvGimnasios.text.toString()
        val coincide = gyms.any {
            it.equals(text, ignoreCase = true)
        }
        if (coincide) {
            Utilidades.animarViewOfInt(binding.butSearchGym,"backgroundColor", ContextCompat.getColor(this,
                R.color.green
            ),1000)
        } else {
            Utilidades.animarViewOfInt(binding.butSearchGym,"backgroundColor", ContextCompat.getColor(this,
                R.color.red
            ),1000)
        }
        boolSearchGym = if (coincide) true else false
        nombreGym = if (coincide) text else return
        binding.tvSelectedGym.text = if (coincide) "Seleccionado: ${text}" else "Seleccionado: Ninguno"
        val textToast = if (coincide) "Gimnasio Encontrado" else "Gimnasio No Encontrado"
        Toast.makeText(this,textToast,Toast.LENGTH_SHORT).show()
    }
    fun clickCheckBox(click: Boolean) {
        val responses: Array<String> = arrayOf("SI","NO")
        var message = ""
        if (click) {
            Utilidades.animarViewOfInt(binding.tvResponse1,"textColor", ContextCompat.getColor(this,
                R.color.green
            ),1000)
            message = "Ahora estás apuntado"
            binding.tvResponse1.text = responses.first()
        } else {
            Utilidades.animarViewOfInt(binding.tvResponse1,"textColor", ContextCompat.getColor(this,
                R.color.red
            ),1000)
            message = "Ahora no estás apuntado"
            binding.tvResponse1.text = responses.last()
        }
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
    fun clickToggleButton(click: Boolean) {
        var message = ""
        if (click) {
            message = "Ahora me está gustando"
        } else {
            message = "Ahora no me está gustando"
        }
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
    fun clickSwitch(click: Boolean) {
        var message = ""
        if (click) {
            Utilidades.animarViewOfInt(binding.tvAntes,"textColor", ContextCompat.getColor(this,
                R.color.green
            ),1000)
            message = "¡Bienvenido de nuevo!"
            binding.switchAntes.thumbTintList = ColorStateList.valueOf(Color.GREEN)
        } else {
            Utilidades.animarViewOfInt(binding.tvAntes,"textColor", ContextCompat.getColor(this,
                R.color.red
            ),1000)
            message = "Felicidades, ¡Es un gran comienzo!"
            binding.switchAntes.thumbTintList = ColorStateList.valueOf(Color.RED)
        }
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}