package com.example.listasensores

import android.view.View
import android.widget.ImageView
import android.widget.TextView

class VistaControler(renglon: View?) {
    var txtNombre: TextView? = null
    var txtVendor: TextView? = null
    var imgSensor: ImageView? = null
    var txtTipo: TextView? = null
    init {
        this.txtNombre = renglon?.findViewById(R.id.nombre)
        this.imgSensor = renglon?.findViewById(R.id.imageView)
        this.txtVendor = renglon?.findViewById(R.id.txtVendor)
        this.txtTipo = renglon?.findViewById(R.id.tipo)
    }
}