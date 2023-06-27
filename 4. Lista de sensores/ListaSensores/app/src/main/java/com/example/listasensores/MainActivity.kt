package com.example.listasensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var sm: SensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        var listaDeSensores : List<Sensor> = sm.getSensorList(Sensor.TYPE_ALL)
        var adapter= ArrayAdapter<Sensor>(applicationContext, android.R.layout.simple_dropdown_item_1line,listaDeSensores)
        //listaSensores.adapter=adapter


        var lista = findViewById<ListView>(R.id.lista)
        var listaSensores: ArrayList<SensorT> = generarDatosSensores(listaDeSensores)

        var adaptadorDatosSensor = AdaptadorSensor(this,listaSensores)
        lista?.adapter = adaptadorDatosSensor
        adaptadorDatosSensor?.notifyDataSetChanged()
    }



    fun generarDatosSensores(lista: List<Sensor>): ArrayList<SensorT> {
        var listaGenerada = ArrayList<SensorT>()
        for (i in lista.indices){
            val nombre = lista.get(i).name
            val vendor = "vendor: "+lista.get(i).vendor
            val version = "version: "+lista.get(i).version.toString()
            val sensor:SensorT = SensorT(nombre,vendor,version,R.drawable.sensor)
            listaGenerada.add(sensor)
        }

        return listaGenerada

    }
}