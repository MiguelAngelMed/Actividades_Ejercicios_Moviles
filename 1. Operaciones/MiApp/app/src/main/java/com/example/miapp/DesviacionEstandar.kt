package com.example.miapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.*

class DesviacionEstandar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desviacion_estandar)
        val edadesNinos = arrayOf<Int>(2,4,4,4,5,5,7,9)

        val btnCalculo = findViewById<Button>(R.id.btnCalcularDesviacion)
        val lblResultado = findViewById<TextView>(R.id.lblResultadoDesviacion)

        btnCalculo.setOnClickListener{
            var sum= 0.0
            for(i in edadesNinos){
                sum += i
            }

            val promedio = sum/edadesNinos.size
            sum=0.0

            for(i in edadesNinos){
                 sum += (i-promedio).toDouble().pow(2)
            }

            val varianza = sum/edadesNinos.size
            lblResultado.text = "La desviación estandar poblacional es: " + sqrt(varianza).toString()
        }
    }
}