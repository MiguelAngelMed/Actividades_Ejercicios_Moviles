package com.example.miapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Operaciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operaciones)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val lblResultado = findViewById<TextView>(R.id.lblResultadoOper)
        val numText = findViewById<EditText>(R.id.txtNumero)


        btnCalcular.setOnClickListener(){
            val numero:String  = numText.text.toString()
            val r : Int = factorial(numero.toInt())
            Toast.makeText(this, "El resultado es"+ r, Toast.LENGTH_LONG).show()
            lblResultado.text = "EL resultado es: "+r
        }


    }
    fun factorial(numero: Int): Int{
        var resultado = 1
        for(x in 1..numero){
            resultado *= x
        }
        return resultado
    }
}

