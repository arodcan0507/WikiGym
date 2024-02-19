package com.example.wikigym.Clases

import android.animation.ObjectAnimator
import android.view.View

object Utilidades {
    fun animarViewOfInt(v: View, atr:String,valor:Int,tiempo:Long) {
        ObjectAnimator.ofInt(v,atr,valor).apply {
            duration = tiempo
            start()
        }
    }
    fun animarViewOfDouble(v: View, atr:String,valor:Float,tiempo:Long) {
        ObjectAnimator.ofFloat(v,atr,valor).apply {
            duration = tiempo
            start()
        }
    }
}