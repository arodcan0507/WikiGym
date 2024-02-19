package com.example.wikigym.Clases

import java.io.Serializable

class Ejercicio(val ID: Int, val Nombre: String, val NSeries: Int, val NReps: Int, val Desc: String, val Imagen: Int, val Musculo: EnumMusculo): Serializable {}

class Usuario(val nombreCompleto: String, val nombreUsuario: String, val email: String, val contrasenia: String, val sexo: EnumSexo, val grado: EnumGrado) {}