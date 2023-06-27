package com.example.listafrases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson

class DetalleFrase : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_frase)
        val fraseJson = intent.getStringExtra("frase")
        val gson = Gson()
        val frase = gson.fromJson<Frase>(fraseJson, Frase::class.java)

        var id = findViewById<TextView>(R.id.txtId)
        id.text = frase.getIdFrase().toString()
        var fraseT = findViewById<TextView>(R.id.txtFrase)
        fraseT.text = '\"'+frase.getFrase()+'\"'
        var autor = findViewById<TextView>(R.id.txtAutor)
        autor.text = frase.getAutor()
        var imgFrase = findViewById<ImageView>(R.id.imagenFrase)
        imgFrase.setImageResource(frase.getImgFrase())
    }
}