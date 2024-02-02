package com.example.wikigym

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wikigym.Clases.Ejercicio
import com.example.wikigym.Clases.EnumMusculo
import com.example.wikigym.databinding.ActivityExerciseBinding
import android.content.Intent
import com.example.wikigym.Clases.ExerciseAdapter


class ExerciseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExerciseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureToolbar()


        val listaEjercicios: MutableList<Ejercicio> = mutableListOf(
            Ejercicio(0,"Press de banca con barra",4,12,"Desengancha la barra y bájala lentamente hasta la parte inferior del pecho. A medida que contraes los pectorales, empuja la carga hacia arriba hasta que los brazos estén casi rectos.",R.drawable.a,EnumMusculo.Pectorales),
            Ejercicio(1,"Apertura con mancuernas",3,12,"Baja lentamente las mancuernas a los lados en un arco con los brazos hasta sentir un estiramiento en los pectorales. No bajes por debajo del nivel de los hombros. Luego vuelve a la posición original, realizando el mismo arco.",R.drawable.b,EnumMusculo.Pectorales),
            Ejercicio(2,"Remo con barra",3,8,"Tira de la carga hacia el abdomen. Aprieta la espalda al final del movimiento, los hombros y los codos hacia atrás. Luego vuelve lentamente a la posición inicial.",R.drawable.c,EnumMusculo.Espalda),
            Ejercicio(3,"Remo en máquina",4,8,"Tira de la carga hacia tu abdomen. Aprieta la espalda al final del movimiento llevando los codos lo más atrás posible. Luego vuelve lentamente a la posición inicial.",R.drawable.d,EnumMusculo.Espalda),
            Ejercicio(4,"Curl con barra",3,15,"Sin mover el pecho, levanta la barra flexionando los antebrazos. Contrae los bíceps en la posición elevada y deja que la barra baje lentamente hasta la posición inicial. Mantén tus codos cerca del cuerpo durante el movimiento.",R.drawable.e,EnumMusculo.Biceps),
            Ejercicio(5,"Curl de cable en polea alta de pie",3,8,"Manteniendo la parte superior de los brazos y el cuerpo fijos, acerca simultáneamente las asas hacia la cabeza tanto como sea posible en un movimiento de curl. Aprieta los bíceps en la parte superior del movimiento, haz una pausa y luego baja lentamente el peso hasta la posición inicial. Haz el ejercicio el número de repeticiones deseadas.",R.drawable.f,EnumMusculo.Biceps),
            Ejercicio(6,"Extensión de tríceps en polea",4,12,"Extender los antebrazos hasta que los brazos estén completamente extendidos. En esta posición, contrae tus tríceps durante un momento y luego vuelve lentamente a la posición inicial. Mantén los codos cerca del cuerpo durante todo el movimiento.",R.drawable.g,EnumMusculo.Triceps),
            Ejercicio(7,"Fondos en banco",5,12,"Mientras mantienes los codos metidos, flexiónalos lentamente hasta que formen un ángulo de 90º. A continuación, vuelve lentamente a la posición inicial y aprieta los tríceps en la parte superior. Mantén la espalda recta durante todo el movimiento. Haz el número de repeticiones deseadas.",R.drawable.h,EnumMusculo.Triceps),
            Ejercicio(8,"Elevación lateral con mancuernas",4,10,"Levanta lentamente los brazos de lado hasta una posición horizontal, manteniendo los codos ligeramente doblados. Contrae los deltoides por un momento en la posición alta, y luego vuelve lentamente a la posición inicial.",R.drawable.j,EnumMusculo.Hombros),
            Ejercicio(9,"Elevación frontal con mancuernas",4,10,"Levanta lentamente los brazos hacia adelante hasta que estén paralelos al suelo. Contrae los deltoides durante un momento en la posición final, luego regresa lentamente a la posición inicial.",R.drawable.k,EnumMusculo.Hombros),
            Ejercicio(10,"Crunch",5,20,"Encoge los abdominales levantando los hombros y la parte superior de la espalda hacia las rodillas. Mantén la parte inferior de la espalda apoyada en el suelo. Quédate en posición vertical por un segundo, y luego vuelve lentamente a la posición original.",R.drawable.l,EnumMusculo.Abdominales),
            Ejercicio(11,"Elevación de piernas",4,12,"Contrae los abdominales moviendo las rodillas y las caderas hacia el pecho. Mantente en posición alta por un segundo, y luego regresa lentamente a la posición inicial.",R.drawable.m,EnumMusculo.Abdominales),
            Ejercicio(12,"Burpees",5,12,"Mientras te sostienes cos las manos, mueve ambas piernas hacia atrás en posición boca arriba y realiza una flexión. Sin detenerse, vuelva a llevar las piernas a la posición inicial de cuclillas y, a continuación, realice un salto vertical levantando las manos hacia el cielo.",R.drawable.n,EnumMusculo.Cuadriceps),
            Ejercicio(13,"Sentadilla Hack",4,12,"Suelta el seguro manual y dobla lentamente las rodillas. Cuando las rodillas estén en un ángulo de 90°, haz una pausa durante un momento y luego levanta lentamente la carga. Mantén la espalda apoyada firmemente en el respaldo.\nPara proteger las rodillas, en la posición alta, detén el movimiento justo antes de que tus piernas estén completamente extendidas.",R.drawable.o,EnumMusculo.Cuadriceps),
            Ejercicio(14,"Elevación de Gemelos Sentado",5,20,"A la vez que contraes los gemelos, levanta los talones lo más alto posible. Permanece en la posición más elevada por un momento, sintiendo bien la contracción. Luego baja lentamente los talones estirando las pantorrillas.",R.drawable.p,EnumMusculo.Gemelos),
            Ejercicio(15,"Elevación de gemelos de pie",4,12,"A la vez que contraes los gemelos, levanta los talones lo más alto posible. Mantente en la posición más elevada por un momento, sintiendo bien la contracción. Luego baja lentamente los talones estirando las pantorrillas.",R.drawable.q,EnumMusculo.Gemelos)
        )

        val adapter = ExerciseAdapter(this,listaEjercicios)

        binding.lvExercise.adapter = adapter

        binding.lvExercise.setOnItemClickListener { adapterView, view, position, id ->
            val intent = Intent(this, ExerciseDetailActivity::class.java)
            intent.putExtra("ejercicio", listaEjercicios[position])
            startActivity(intent)
        }
    }

    fun configureToolbar() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Ejercicios"
    }
}