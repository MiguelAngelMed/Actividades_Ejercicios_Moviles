package com.example.appejercicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

        //Definicion de las variables
        private lateinit var preferencias : DarkPreferenceManager
        private lateinit var correoElectronico: EditText
        private lateinit var claveUsuario: EditText

        //variable de apoyo
        //Se usa lateinit para inicializar despues
        private lateinit var usuario: String
        private lateinit var clave: String

        //validando correo y clave
        private var emailValido = "mail@gmail.com"
        private var claveValida = "123456"




        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            inicializar()
            verificarLogin()
        }

        private fun inicializar(){
            preferencias = DarkPreferenceManager(this)
            correoElectronico = findViewById<EditText>(R.id.txtEmail)
            claveUsuario = findViewById<EditText>(R.id.txtClave)
        }

        private fun verificarLogin(){
            /*
            * Al utilizar el operador "!!", se le está diciendo al compilador que se garantiza
            *  que la expresión en cuestión no será nula
            * */
            if(preferencias.isLogin()!!){
                val bienvenidoIntent = Intent(this,Bienvenido::class.java)
                startActivity(bienvenidoIntent)
                finish()
            }
        }

        fun iniciarSesion(view: View){
            usuario = correoElectronico.text.toString().trim()
            clave = claveUsuario.text.toString().trim()


            if(usuario.isEmpty() || usuario == ""){
                correoElectronico.error = "correo electrónico requerido"
                correoElectronico.requestFocus()
            }
            else if(clave.isEmpty() || clave == ""){
                claveUsuario.error = "Clave requerido "
                claveUsuario.requestFocus()
            }
            else if (usuario != emailValido){
                correoElectronico.error = "Correo electrónico invalido"
                correoElectronico.requestFocus()
            }
            else if(clave != claveValida){
                claveUsuario.error = "Clave invalida"
                claveUsuario.requestFocus()
            }
            else{
                preferencias.setLogin(true)
                preferencias.setNombreDeUsuario(usuario)

                val bienvenidoIntent = Intent(this,Bienvenido::class.java)
                startActivity(bienvenidoIntent)
                //finish() se usa para finalizar una actividad (Activity) en una aplicación de Android
                finish()
            }


        }



}