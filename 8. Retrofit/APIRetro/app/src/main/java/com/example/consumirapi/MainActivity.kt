package com.example.consumirapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.consumirapi.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), OnQueryTextListener, SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PerroAdapter
    private val imagenesDePerros= mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.svPerros.setOnQueryTextListener(this)
        iniciarRecyclerView()
    }

    fun obtenerRetroFit(): Retrofit{
        return Retrofit.Builder().baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buscarPorNombre(query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<PerrosResponse> = obtenerRetroFit().create(APIService::class.java).obtenerPerrosPorRazas("$query/images")
            //val cachorros: PerrosResponse? = call.body()
            val cachorros: PerrosResponse? = call.body()

            runOnUiThread(){
                if(call.isSuccessful){
                    //mostrar recycler view
                    val imagenes: List<String> =  cachorros?.images ?: emptyList()
                    imagenesDePerros.clear()
                    imagenesDePerros.addAll(imagenes)
                    adapter.notifyDataSetChanged()
                }else{
                    mostrarErrores()
                }
                ocultarTeclado()
            }
        }
    }

    private fun mostrarErrores(){
        Toast.makeText(this,"error",Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            buscarPorNombre(query.lowercase())
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

    private fun iniciarRecyclerView(){
        adapter= PerroAdapter(imagenesDePerros)
        binding.rvPerros.layoutManager = LinearLayoutManager(this)
        binding.rvPerros.adapter = adapter
    }

    private fun ocultarTeclado(){
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.vistaPrincipal.windowToken,0)
    }

}