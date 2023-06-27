package com.example.listafrutas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var lista = findViewById<ListView>(R.id.lista)
        var listaFrutas: ArrayList<Articulo> = generarDatosFrutas()
        var adaptadorDatosArticulo = AdaptadorArticulo(this, listaFrutas)
        lista?.adapter = adaptadorDatosArticulo
        adaptadorDatosArticulo?.notifyDataSetChanged()

    }

    fun generarDatosFrutas(): ArrayList<Articulo>{
        var listaDeArticulos = ArrayList<Articulo>()
        var a1: Articulo = Articulo("Fresa"
        ,500.0,"Rica fresa",
        R.drawable.fresa)
        listaDeArticulos.add(a1)

        a1 = Articulo("Mango"
            ,90.0,"Rico mango",
            R.drawable.mango)
        listaDeArticulos.add(a1)

        a1 = Articulo("Sandia"
            ,135.0,"Rica sandia",
            R.drawable.sandia)
        listaDeArticulos.add(a1)

        a1 = Articulo("Kiwi"
            ,135.0,"Rica kiwi",
            R.drawable.kiwi)
        listaDeArticulos.add(a1)

        a1 = Articulo("Manzana"
            ,2409.0,"Rica manzana",
            R.drawable.manzana)
        listaDeArticulos.add(a1)

        a1 = Articulo("Naranja"
            ,5.0,"Rica naranja",
            R.drawable.naranja)
        listaDeArticulos.add(a1)


        return listaDeArticulos
    }
}