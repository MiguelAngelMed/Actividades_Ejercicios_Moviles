package com.example.ejemplodb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.FileReader

class ListaFrases() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_frases)

        val jsonArrayString = intent.getStringExtra("miArrayList")
        if (jsonArrayString != null) {
            val gson = Gson()
            val type = object : TypeToken<ArrayList<Frase>>() {}.type
            val arrayListFrase: ArrayList<Frase> = gson.fromJson(jsonArrayString, type)


            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
            val adapter = FraseAdapter(arrayListFrase)

            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = adapter
        }
    }
}