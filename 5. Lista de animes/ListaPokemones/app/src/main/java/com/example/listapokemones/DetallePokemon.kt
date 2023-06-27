package com.example.listapokemones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson

class DetallePokemon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pokemon)

        val pokemonJson = intent.getStringExtra("pokemon")
        val gson = Gson()
        val pokemon = gson.fromJson<Pokemon>(pokemonJson, Pokemon::class.java)

        var nombre = findViewById<TextView>(R.id.txtNombrePoke)
        nombre.text = pokemon.nombre
        var tipo = findViewById<TextView>(R.id.txtTipoPoke)
        tipo.text = pokemon.tipo
        var habilidad = findViewById<TextView>(R.id.txtHabilidadPoke)
        habilidad.text = pokemon.habilidad
        var imgPoke = findViewById<ImageView>(R.id.imagenPokemon)
        imgPoke.setImageResource(pokemon.imagenPokemon)

    }
}