package com.example.ejemplodb

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class FraseAdapter(val listaFrase: ArrayList<Frase>): RecyclerView.Adapter<FraseAdapter.ManejadorVista>() {
    class ManejadorVista(elementoVista: View) : RecyclerView.ViewHolder(elementoVista){
        var imagenFrase : ImageView
        var frase : TextView
        init {
            imagenFrase = elementoVista.findViewById(R.id.imagenFrase)
            frase = elementoVista.findViewById(R.id.frase)
        }
    }

    /* esta función se utiliza para crear y devolver un nuevo ViewHolder que contiene la vista inflada del diseño de cada elemento en la lista*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManejadorVista {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.card_item_layout,parent, false)
        return ManejadorVista(vista)
    }

    override fun getItemCount(): Int {
        return listaFrase.size
    }

    override fun onBindViewHolder(holder: ManejadorVista, position: Int) {
        val frase = listaFrase[position]
        holder.imagenFrase.setImageResource(frase.getImgFrase())
        holder.frase.text = frase.getFrase()
        holder.itemView.tag = frase

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetalleFrase::class.java)
            val gson = Gson()
            val fraseJson = gson.toJson(frase)
            intent.putExtra("frase",fraseJson)
            holder.itemView.context.startActivity(intent)
        }
    }


}