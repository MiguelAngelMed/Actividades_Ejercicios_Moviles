package com.example.listapokemones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val lista : ArrayList<Pokemon> = generarPokemones()
        val adapter = AnimeAdapter(lista)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter= adapter
    }
    fun generarPokemones(): ArrayList<Pokemon>{
        var listaP = ArrayList<Pokemon>()

        var objeto: Pokemon
        objeto = Pokemon("Pikachu","Eléctrico", "Electricidad Estática",R.drawable.pikachu)
        listaP.add(objeto)
        objeto = Pokemon("Eevee","Normal","Fuga",R.drawable.evee)
        listaP.add(objeto)
        objeto = Pokemon("Squirtle","Agua","Torrente",R.drawable.squirtle)
        listaP.add(objeto)
        objeto = Pokemon("Gardevoir","Hada","Calco",R.drawable.gardevoir)
        listaP.add(objeto)
        objeto = Pokemon("Dragonite","Dragón","Fuerza mental",R.drawable.dragonite)
        listaP.add(objeto)

        return listaP
    }
}