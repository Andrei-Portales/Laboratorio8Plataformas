package com.portales.laboratorio8plataformas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.portales.laboratorio8plataformas.Busqueda.BusquedaViewModel
import com.portales.laboratorio8plataformas.Models.Result

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : BusquedaViewModel
    private lateinit var lista : List<Result>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(BusquedaViewModel::class.java)

        val resultadosObserver = Observer<List<Result>>{
            lista = it
        }

        viewModel.getListaResultsLiveData().observe(this, resultadosObserver)
        viewModel.getData()

    }

    fun getLista(): List<Result>{
        return lista
    }


    fun consultaProvisional(){
        var url = "http://hn.algolia.com/api/v1/search"
        var queue = Volley.newRequestQueue(this)
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                Log.d("RESPONSE", response.get("hits").toString())
            },
            Response.ErrorListener { error ->
                Log.d("ERROR", error.message)
            }
        )
        jsonObjectRequest.setRetryPolicy(DefaultRetryPolicy(60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT))
        queue.add(jsonObjectRequest)
    }
}
