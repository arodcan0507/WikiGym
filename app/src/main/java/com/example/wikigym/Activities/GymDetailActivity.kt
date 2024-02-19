package com.example.wikigym

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.MediaController
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.example.wikigym.databinding.ActivityGymDetailBinding

class GymDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGymDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGymDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombreGym = intent.getStringExtra("nombreGym")

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = nombreGym

        binding.titleGym.text = nombreGym

        configureSearchView()
        configureWebView()
        configureVideoView()

        binding.butContinua.setOnClickListener {
            val intent = Intent(this, GymDetail2Activity::class.java)
            startActivity(intent)
        }
    }
    fun configureSearchView() {
        binding.searchGym.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    Toast.makeText(this@GymDetailActivity, getString(R.string.coincidencia), Toast.LENGTH_SHORT).show()
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }
    fun configureWebView() {
        val url = "https://www.simplyfitness.com/es"
        binding.wvUrlGym.webViewClient = WebViewClient()
        binding.wvUrlGym.loadUrl(url)
        binding.wvUrlGym.settings.javaScriptEnabled = true
        binding.wvUrlGym.settings.supportZoom()
    }
    fun configureVideoView() {
        val videoPath = "android.resource://${packageName}/${R.raw.rocky}"
        val mediaController = MediaController(this)
        binding.videoView.setVideoPath(videoPath)
        binding.videoView.setMediaController(mediaController)
        binding.videoView.setOnPreparedListener {mediaPlayer ->
            mediaPlayer.start()
        }
    }
}