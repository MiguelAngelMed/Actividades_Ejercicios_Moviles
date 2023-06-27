package com.example.appejercicio

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Bienvenido : AppCompatActivity() {
    //Definicion de las variables
    private lateinit var preferencias: DarkPreferenceManager

    //variables de apoyo
    private lateinit var usuario: String
    private lateinit var lblDatos: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenido)

        inicializar()
        verificarLogin()

    }

    private fun inicializar(){
        preferencias = DarkPreferenceManager(this)
        usuario = preferencias.getNombreDeUsuario().toString()
        lblDatos = findViewById<TextView>(R.id.lblBienvenido)
        setLblDatos()

    }

    private fun verificarLogin(){
        if(preferencias.isLogin() == false){
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }
    }

    private fun setLblDatos(){
        lblDatos.text = "Bienvenido: $usuario"
    }

    fun cerrarSesion(view: View){
        preferencias.limpiarPreferencias()
        val mainIntent = Intent(this, MainActivity::class.java)
        startActivity(mainIntent)
        finish()

    }

    fun llamar(view: View){
        val llamarAct = Intent().apply {
            action = Intent.ACTION_DIAL
            data = Uri.parse("tel:00000000")
        }

        startActivity(llamarAct)
    }

    fun enviarCorreo(view: View){
        val enviar = Intent().apply {
            action = Intent.ACTION_SEND
            type = "text/plain"
        }

        enviar.putExtra(Intent.EXTRA_EMAIL,"v3mikeangel@gmail.com")
        val title = resources.getString(R.string.elige)
        val chooser = Intent.createChooser(enviar,title)
        startActivity(chooser)
    }

}