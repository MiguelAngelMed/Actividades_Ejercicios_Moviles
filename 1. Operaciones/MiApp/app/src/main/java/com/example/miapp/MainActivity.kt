package com.example.miapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("MISDATOS",Context.MODE_PRIVATE)
        val nombreUsuario = sharedPreferences.getString("nombreDeUsuario","").toString()
        val contraUsuario = sharedPreferences.getString("claveDeUsuario","").toString()

        if( nombreUsuario != "" && contraUsuario != "") {
            bienvenidoActivity()
        }else {
            findViewById<Button>(R.id.btnEntrar).setOnClickListener{
                val chkRecuerdame = findViewById<CheckBox>(R.id.checkRecuerdame)
                val usuario = findViewById<EditText>(R.id.txtUsuario).text.toString()
                val contrasena = findViewById<EditText>(R.id.txtPassword).text.toString()



                if(usuario.isNotEmpty() && contrasena.isNotEmpty()){
                    if(chkRecuerdame.isChecked){
                        val editor = sharedPreferences.edit()
                        editor.putString("nombreDeUsuario", usuario)
                        editor.putString("claveDeUsuario",contrasena)
                        editor.apply()

                        bienvenidoActivity()
                    }else{
                        val bienvenidoIntent = Intent(this, Bienvenido::class.java).also {
                            it.putExtra("NOMBRE", usuario)
                            it.putExtra("CONTRASENA",contrasena)
                            startActivity(it)
                        }
                    }

                }else{ Toast.makeText(this,"Introduce todos los datos porfavor",Toast.LENGTH_LONG).show() }
            }
        }




    }

    fun bienvenidoActivity(){
        val i = Intent(this, Bienvenido::class.java)
        startActivity(i)
    }
}
