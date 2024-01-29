package com.example.wikigym

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.wikigym.Clases.Ejercicio
import com.example.wikigym.databinding.ActivityExerciseBinding
import java.util.ArrayList

class ExerciseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExerciseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureToolbar()

        val ejercicios = arrayOf(
            "Press Banca","Press Declinado","Curl Biceps","Fondos","Dominadas"
        )
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item,ejercicios)

        binding.lvExercise.isClickable = true
        binding.lvExercise.adapter = adapter
    }

    fun configureToolbar() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Ejercicios"
    }
}