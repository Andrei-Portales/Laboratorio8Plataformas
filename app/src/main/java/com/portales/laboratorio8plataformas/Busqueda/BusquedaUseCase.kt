package com.portales.laboratorio8plataformas.Busqueda

import android.content.Context
import com.portales.laboratorio8plataformas.Models.Result
import org.json.JSONObject

class BusquedaUseCase (){

    val resultrepository = BusquedaRepository()

    fun getDataList(): List<Result>{
        return resultrepository.createResultList()
    }
}