package com.example.listafrases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val lista : ArrayList<Frase> = generarFrases()
        val adapter = FraseAdapter(lista)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter= adapter
    }
    fun generarFrases(): ArrayList<Frase>{
        var listaP = ArrayList<Frase>()

        var objeto: Frase
        objeto = Frase(1,"Mamá siempre decía que la vida era como una caja de chocolates. Nunca sabes qué te va a tocar",
                "Forrest Gump",R.drawable.forest)
        listaP.add(objeto)
        objeto = Frase(2,"He cruzado océanos de tiempo para encontrarte","Dracula",R.drawable.dracula)
        listaP.add(objeto)
        objeto = Frase(3,"Haz de tu vida un sueño, y de tu sueño una realidad","El principito",R.drawable.principito)
        listaP.add(objeto)
        objeto = Frase(4,"Cada persona es el reflejo de la música que escucha","Jonh Lennon",R.drawable.john)
        listaP.add(objeto)
        objeto = Frase(5,"Cuando amas a alguien, permanece dentro de tu corazón para siempre","Tierra de osos",R.drawable.osos)
        listaP.add(objeto)

        return listaP
    }
}