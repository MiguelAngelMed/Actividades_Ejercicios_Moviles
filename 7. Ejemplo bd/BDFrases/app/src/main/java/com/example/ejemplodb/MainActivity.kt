package com.example.ejemplodb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    lateinit var frase: EditText
    lateinit var autor: EditText
    lateinit var btnGuardar: Button
    lateinit var btnListado: Button
    lateinit var tvDatos: TextView
    lateinit var texto: String


    lateinit var db: SQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Jalamos los elementos
        frase = findViewById(R.id.txtFrase)
        autor = findViewById(R.id.txtAutor)

        texto = ""

        btnGuardar = findViewById(R.id.btnGuardar)
        btnListado = findViewById(R.id.btnListado)

        // Asignamos los 'ESCUCHA'
        db = SQLiteHelper(this)

        btnGuardar.setOnClickListener(){
            val laFrase = frase.text.toString()
            val elAutor = autor.text.toString()

            // Creamos al instancia de la clase frase
            val f = Frase(laFrase, elAutor,R.drawable.nota)

            val almacenado = db.create(f)

            if(almacenado == true){
                Toast.makeText(this, "Se ha almacenado correctamente el dato", Toast.LENGTH_SHORT).show()
                frase.text.clear()
                autor.text.clear()
            }
        } // btnGuardar

        btnListado.setOnClickListener(){
            var listaFrases:ArrayList<Frase> = generarFrases()
            val gson = Gson()
            val jsonArray = gson.toJsonTree(listaFrases)

            val intentLista = Intent(this, ListaFrases::class.java)
            intentLista.putExtra("miArrayList",jsonArray.toString())
            startActivity(intentLista)

        }//btnListado

    }// end onCreate

    fun generarFrases():ArrayList<Frase>{
        var listaP = ArrayList<Frase>()
        var objeto:Frase

        val cursor = db.readAll()
        val numeroFilas : Int = cursor.count
        cursor.moveToFirst()
        for(i in 1 .. numeroFilas){
            var id : Int = cursor.getInt(0)
            var frase : String = cursor.getString(1)
            var autor : String = cursor.getString(2)
            objeto = Frase(frase,autor,R.drawable.nota)
            objeto.setIdFrase(id)
            listaP.add(objeto)
            cursor.moveToNext()
        }// endFor
        return listaP
    }

}
