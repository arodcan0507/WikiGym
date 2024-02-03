package com.example.wikigym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        binding.butLogin.setOnClickListener {
            val userLogin = binding.etUsername.text.toString()
            val passwordLogin = binding.etPassword.text.toString()
            if (user.equals(userLogin) && password.equals(passwordLogin)) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                val toast = Toast.makeText(this,"Login Incorrecto",Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }
}