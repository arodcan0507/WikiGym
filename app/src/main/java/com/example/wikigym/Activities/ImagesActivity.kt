package com.example.wikigym.Activities

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.wikigym.Clases.Utilidades
import com.example.wikigym.R
import com.example.wikigym.databinding.ActivityImagesBinding

class ImagesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImagesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding = ActivityImagesBinding.inflate(layoutInflater)
        supportActionBar!!.title = "GYM"
        setContentView(binding.root)

        Utilidades.animarViewOfDouble(binding.titleImagenes, "textSize",30f,1000)
    }
}