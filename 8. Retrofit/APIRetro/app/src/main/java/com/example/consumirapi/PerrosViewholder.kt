package com.example.consumirapi

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.consumirapi.databinding.ElementoPerroBinding
import com.squareup.picasso.Picasso

class PerrosViewholder (view: View): RecyclerView.ViewHolder(view){
    private val binding = ElementoPerroBinding.bind(view)
    fun bind(imagen: String){
        Picasso.get().load(imagen).into(binding.ivPerro)
    }
}