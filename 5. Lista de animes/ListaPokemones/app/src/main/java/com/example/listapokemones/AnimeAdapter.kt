package com.example.listapokemones

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson


/*se utiliza para adaptar una lista de elementos a una vista de RecyclerView.
La clase AnimeAdapter también especifica que su ViewHolder personalizado es el objeto ManejadorVista*/
class AnimeAdapter(val listaPokemon: ArrayList<Pokemon>): RecyclerView.Adapter<AnimeAdapter.ManejadorVista>() {
    class ManejadorVista(elementoVista: View) : RecyclerView.ViewHolder(elementoVista){
        var imagenAnime : ImageView
        var nombreAnime : TextView
        init {
            imagenAnime = elementoVista.findViewById(R.id.imagenAnime)
            nombreAnime = elementoVista.findViewById(R.id.nombreAnime)
        }
    }

    /* esta función se utiliza para crear y devolver un nuevo ViewHolder que contiene la vista inflada del diseño de cada elemento en la lista*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManejadorVista {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.card_item_layout,parent, false)
        return ManejadorVista(vista)
    }

    override fun getItemCount(): Int {
        return listaPokemon.size
    }

    override fun onBindViewHolder(holder: ManejadorVista, position: Int) {
        val pokemon = listaPokemon[position]
        holder.imagenAnime.setImageResource(pokemon.imagenPokemon)
        holder.nombreAnime.text = pokemon.nombre
        holder.itemView.tag = pokemon

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetallePokemon::class.java)
            val gson = Gson()
            val pokemonJson = gson.toJson(pokemon)
            intent.putExtra("pokemon",pokemonJson)
            holder.itemView.context.startActivity(intent)
        }
    }


}