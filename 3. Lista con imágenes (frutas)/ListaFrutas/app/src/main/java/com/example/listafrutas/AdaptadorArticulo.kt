package com.example.listafrutas

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import java.text.FieldPosition


/*
* define un adaptador de vista para una lista de objetos de tipo Articulo.
* El adaptador se utiliza comúnmente en aplicaciones de Android para vincular
*  datos con la interfaz de usuario.*/
class AdaptadorArticulo (
    private var activity: Activity,
    private var items: ArrayList<Articulo>):BaseAdapter(){
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Articulo {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, converterView: View?,parent: ViewGroup?): View {
        val vistaACargar: View?
        val vista: VistaControler
        if(converterView == null){
            /*
            *Se utiliza para obtener un objeto LayoutInflater a través del objeto activity, lo que permite inflar(convertir)
            * archivos de diseño XML en vistas reales de la interfaz de usuario.
            * */
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            vistaACargar = inflater.inflate(R.layout.elemento_articulo,null)
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
        var articulos = items[position]
        vista.imgArticulo?.setImageResource(articulos.imgagenArticulo)
        vista.txtNombre?.text = articulos.nombreArticulo
        vista.txtDetalle?.text = articulos.descripcionArticulo
        vista.txtPrecio?.text = articulos.precioArticulo.toString()

        vistaACargar?.setOnClickListener(){
            Toast.makeText(activity,"Articulo seleccionado: ${articulos.nombreArticulo}",Toast.LENGTH_SHORT).show()


        }

        return vistaACargar as View
    }

    }

/*
* El adaptador hereda de la clase BaseAdapter, lo que significa que debe proporcionar una implementación para
* los métodos abstractos getCount(), getItem(), getItemId(), y getView().
* El método getView(position: Int, convertView: View?, parent: ViewGroup?) es el método más importante en el adaptador,
* ya que es responsable de crear y devolver una vista que represente un elemento de la lista.
*  Este método utiliza un objeto VistaControler para cargar y mapear las vistas de un diseño XML a un objeto Kotlin.*/