package com.example.wikigym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.example.wikigym.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    companion object {
        var user = "admin"
        var password = "1234"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Login"

        var tiempo = 2000

        binding.butLogin.setOnClickListener {
            val userLogin = binding.etUsername.text.toString()
            val passwordLogin = binding.etPassword.text.toString()
            if (user.equals(userLogin) && password.equals(passwordLogin)) {
                showProgressBar()

                Handler().postDelayed({
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }, tiempo.toLong())
            } else {
                var message = "Login Incorrecto"
                val toast = Toast.makeText(this,message,Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }
    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }
}