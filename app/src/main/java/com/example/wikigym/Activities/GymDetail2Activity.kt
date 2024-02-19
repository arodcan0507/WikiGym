package com.example.wikigym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import com.example.wikigym.databinding.ActivityGymDetail2Binding

class GymDetail2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityGymDetail2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGymDetail2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "GYM"

        configureProgressBar()
        configureCalendarView()
        configureRatinBar()

        binding.btnImagenes.setOnClickListener {
            val intent = Intent(this,ImagesActivity::class.java)
            startActivity(intent)
        }
    }
    fun configureProgressBar() {
        var valoration: Int = 0
        binding.seekbarValoracion.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                valoration = progress + 1
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                val message = "La reseña es ${valoration} estrellas"
                Toast.makeText(this@GymDetail2Activity,message, Toast.LENGTH_SHORT).show()
            }

        })
    }
    fun configureCalendarView() {
        binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val formattedDate = String.format("%02d-%02d-%04d", dayOfMonth, month + 1, year)
            Toast.makeText(this, "Fecha seleccionada: $formattedDate", Toast.LENGTH_SHORT).show()
        }
    }
    fun configureRatinBar() {
        binding.ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            Toast.makeText(this, "Calificación: ${rating}", Toast.LENGTH_SHORT).show()
        }
    }
}