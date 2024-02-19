package com.example.wikigym

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ImagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "GYM"
        setContentView(R.layout.activity_images)
    }
}