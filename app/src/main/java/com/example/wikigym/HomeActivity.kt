package com.example.wikigym

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.wikigym.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cvExercise.setOnClickListener {
            val intent = Intent(this,ExerciseActivity::class.java)
            startActivity(intent)
        }

        binding.cvFood.setOnClickListener {
            val intent = Intent(this,FoodActivity::class.java)
            startActivity(intent)
        }

        binding.cvIMC.setOnClickListener {
            val intent = Intent(this,IMCActivity::class.java)
            startActivity(intent)
        }
    }
}