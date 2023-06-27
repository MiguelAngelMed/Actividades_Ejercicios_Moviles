package com.example.appejercicio

import android.content.Context
import android.content.SharedPreferences
import android.text.BoringLayout

class DarkPreferenceManager(contexto: Context?) {
    //Definir el modo del Shared Preferenes
    val  MODO_PRIVADO = 0

    //Nombre del archivo de preferencias
    private val PREFERENCE_NAME = "DarkSharedPrefrences"
    private val  IS_LOGIN = "is_login"

    /* El operador ?
    *  Se utiliza para llamar a un método o acceder a una propiedad en una
    *  variable que puede ser nula sin generar una excepción "NullPointerException"
    * */
    val preferencias: SharedPreferences? = contexto?.getSharedPreferences(PREFERENCE_NAME,MODO_PRIVADO)
    val editor : SharedPreferences.Editor? = preferencias?.edit();


    /*
    * El método edit() de SharedPreferences se utiliza para obtener un objeto de
    * tipo SharedPreferences.Editor, que se utiliza para realizar cambios en los valores
    * almacenados en las preferencias compartidas*/
    fun setLogin(isLogin: Boolean){
        editor?.putBoolean(IS_LOGIN,isLogin)
        editor?.commit()
    }

    fun isLogin( ) :Boolean?{
        return preferencias?.getBoolean(IS_LOGIN,false)
    }

    fun setNombreDeUsuario(nombreDeUsuario: String?){
        editor?.putString("nombreDeUsuario",nombreDeUsuario)
        editor?.commit()
    }

    fun getNombreDeUsuario() : String?{
        return preferencias?.getString("nombreDeUsuario","")
    }

    fun limpiarPreferencias(){
        editor?.clear()
        editor?.commit()
    }
}