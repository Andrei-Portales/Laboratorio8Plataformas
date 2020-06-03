package com.portales.laboratorio8plataformas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.portales.laboratorio8plataformas.Busqueda.BusquedaViewModel
import com.portales.laboratorio8plataformas.Models.Result

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : BusquedaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(BusquedaViewModel::class.java)

        val resultadosObserver = Observer<List<Result>>{

        }
    }
}
