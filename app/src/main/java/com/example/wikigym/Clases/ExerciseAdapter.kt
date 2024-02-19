package com.example.wikigym.Clases

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.wikigym.R

class ExerciseAdapter(private val mContext: Context,private val listaExercise: MutableList<Ejercicio>): ArrayAdapter<Ejercicio>(mContext,0,listaExercise) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout: View = LayoutInflater.from(mContext).inflate(R.layout.listviewcustom,parent,false)

        val ejercicio = listaExercise[position]

        val imgExercise = layout.findViewById<ImageView>(R.id.imageExercise)
        val titleExercise = layout.findViewById<TextView>(R.id.titleExercise)
        val seriesxRepsExercise = layout.findViewById<TextView>(R.id.seriesreps)

        val seriesReps = "Series: ${ejercicio.NSeries} | Reps: ${ejercicio.NReps}"
        imgExercise.setImageResource(ejercicio.Imagen)
        titleExercise.text = ejercicio.Nombre
        seriesxRepsExercise.text = seriesReps

        return layout
    }
}