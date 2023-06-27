package com.example.listafrutas

import android.view.View
import android.widget.ImageView
import android.widget.TextView

/*
* define un controlador de vista que se utiliza para mapear vistas de un diseño de UI en objetos Kotlin*/
class VistaControler(renglon: View?) {
    var txtNombre: TextView? = null
    var txtDetalle: TextView? = null
    var imgArticulo: ImageView? = null
    var txtPrecio: TextView? = null
    init {
        this.txtNombre = renglon?.findViewById(R.id.nombre)
        this.imgArticulo = renglon?.findViewById(R.id.imageView)
        this.txtDetalle = renglon?.findViewById(R.id.txtDescripcion)
        this.txtPrecio = renglon?.findViewById(R.id.precio)
    }
}