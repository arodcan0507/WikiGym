package com.example.wikigym.Clases

import android.graphics.drawable.Drawable
import java.io.Serializable

class Ejercicio(val ID: Int, val Nombre: String, val NSeries: Int, val NReps: Int, val Desc: String, val Imagen: Int, val Musculo: EnumMusculo): Serializable {

}