package com.example.listasensores

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast

class AdaptadorSensor (
    private var activity: Activity,
    private var items: ArrayList<SensorT>): BaseAdapter(){
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): SensorT {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, converterView: View?, parent: ViewGroup?): View {
        val vistaACargar: View?
        val vista: VistaControler
        if(converterView == null){
            /*
            *Se utiliza para obtener un objeto LayoutInflater a través del objeto activity, lo que permite inflar(convertir)
            * archivos de diseño XML en vistas reales de la interfaz de usuario.
            * */
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            vistaACargar = inflater.inflate(R.layout.elemento_sensor,null)
            vista = VistaControler(vistaACargar)
            vistaACargar?.tag = vista
            /*
            * establece una etiqueta personalizada en la vista inflada.
            * En este caso, la etiqueta se establece en la instancia de la clase VistaControler,
            * que se utiliza para almacenar una referencia a la vista inflada. La etiqueta personalizada
            * se puede utilizar posteriormente para recuperar la vista inflada y sus elementos de vista asociados.
            * */


        }else{
            vistaACargar = converterView
            vista = vistaACargar.tag as VistaControler
        }
        var sensores = items[position]
        vista.imgSensor?.setImageResource(sensores.imgSensor)
        vista.txtNombre?.text = sensores.nombreSensor
        vista.txtVendor?.text = sensores.vendorSensor
        vista.txtTipo?.text = sensores.versionSensor

        vistaACargar?.setOnClickListener(){
            Toast.makeText(activity,"Articulo seleccionado: ${sensores.nombreSensor}", Toast.LENGTH_SHORT).show()


        }

        return vistaACargar as View
    }

}
