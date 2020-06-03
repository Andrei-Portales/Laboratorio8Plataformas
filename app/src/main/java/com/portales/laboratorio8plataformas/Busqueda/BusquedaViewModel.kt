package com.portales.laboratorio8plataformas.Busqueda

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.portales.laboratorio8plataformas.Models.Result
import com.portales.laboratorio8plataformas.Models.SearchData

class BusquedaViewModel : ViewModel() {

    val busquedaUseCase = BusquedaUseCase()

    private val data = MutableLiveData<List<Result>>()


    fun setdatos(data: List<Result>){
       this.data.value = data
    }

    fun getData(){
        setdatos(busquedaUseCase.getDataList())
    }

    fun getListaFrutasLiveData(): LiveData<List<Result>>{
        return data
    }

}