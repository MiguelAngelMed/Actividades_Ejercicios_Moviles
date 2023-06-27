package com.example.miapp


import android.content.Context
import android.content.Intent
import android.graphics.Region.Op
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.awt.font.TextAttribute

class Bienvenido : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenido)

        val sharedPreferences = getSharedPreferences("MISDATOS", Context .MODE_PRIVATE)
        val nombreUsuario =  sharedPreferences.getString("nombreDeUsuario","").toString()
        val contraUsuario =  sharedPreferences.getString("claveDeUsuario","").toString()

        val lblDatos = findViewById<TextView>(R.id.lblUserSesion)
        if( nombreUsuario != "" && contraUsuario != "") {
            lblDatos.text = nombreUsuario
        }else{
            val usuario = intent.getStringExtra("NOMBRE")
            val contrasena = intent.getStringExtra("CONTRASENA")
            lblDatos.text = usuario


        }





        operaciones()
        desviacionEstandar()
    }

    fun operaciones(){
       findViewById<Button>(R.id.btnOperaciones).setOnClickListener{
           val operacionesIntent = Intent(this, Operaciones::class.java).also {
               startActivity(it)
           };
       }
    }

    fun desviacionEstandar(){
        findViewById<Button>(R.id.btnDesviacion).setOnClickListener{
            val desviacionIntent = Intent(this, DesviacionEstandar::class.java).also {
                startActivity(it)
            };
        }
    }
}