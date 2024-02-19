package com.example.wikigym.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wikigym.Clases.Ejercicio
import com.example.wikigym.databinding.ActivityExerciseDetailBinding

class ExerciseDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExerciseDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val ejercicio = intent.getSerializableExtra("ejercicio") as Ejercicio
        val nombre = "Detalle ${ejercicio.Nombre}"

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = nombre

        binding.NameExercise.text = ejercicio.Nombre
        binding.ImageExercise.setImageResource(ejercicio.Imagen)
        binding.NSeriesNRepsExercise.text = "Nº Series: ${ejercicio.NSeries} | Nº Reps: ${ejercicio.NReps}"
        binding.DescExercise.text = ejercicio.Desc
        binding.grupoExercise.text = "Músculo trabajado: ${ejercicio.Musculo}"
    }
}