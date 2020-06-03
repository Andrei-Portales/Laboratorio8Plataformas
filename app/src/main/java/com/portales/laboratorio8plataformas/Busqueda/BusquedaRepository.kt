package com.portales.laboratorio8plataformas.Busqueda

import com.portales.laboratorio8plataformas.Models.Result

class BusquedaRepository {

    fun createResultList() : List<Result>{
        return listOf<Result>(
            Result("Andrei","10-20-51",1000),
            Result("Prueba", "20-15-98", 5000))
    }
}