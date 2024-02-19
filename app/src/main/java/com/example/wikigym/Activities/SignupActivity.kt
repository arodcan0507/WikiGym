package com.example.wikigym.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.example.wikigym.Clases.EnumGrado
import com.example.wikigym.Clases.EnumSexo
import com.example.wikigym.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private var masc: Boolean = false
    private var level: EnumGrado = EnumGrado.Principiante
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "SignUp"

        binding.rbMasc.setOnClickListener {
            masc = true
        }

        binding.chipsNivel1.setOnClickListener {
            level = EnumGrado.Principiante
        }
        binding.chipsNivel2.setOnClickListener {
            level = EnumGrado.Intermedio
        }
        binding.chipsNivel3.setOnClickListener {
            level = EnumGrado.Avanzado
        }

        binding.butSignup.setOnClickListener {
            crearCuenta()
        }

    }

    fun crearCuenta() {
        val name = binding.etName.text.toString()
        val username = binding.etusername.text.toString()
        val email = binding.etemail.text.toString()
        val password = binding.etpassword.text.toString()
        val sex = if (masc) EnumSexo.Masculino else EnumSexo.Femenino
        val levelUser = level
        var message = ""
        var userCreated = false

        if (name.isNotEmpty() && username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            message = "Usuario creado correctamente"
            userCreated = true
            LoginActivity.user = username
            LoginActivity.password = password
        } else {
            message = "Algunos datos sin incorrectos"
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        if (userCreated) {
            var tiempo = 2000
            Handler().postDelayed({
                binding.progressBarSignUp.visibility = View.VISIBLE
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }, tiempo.toLong())
        }
    }
}