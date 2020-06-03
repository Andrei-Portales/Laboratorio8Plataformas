package com.portales.laboratorio8plataformas.Busqueda

import com.portales.laboratorio8plataformas.Models.Result
import com.portales.laboratorio8plataformas.Models.RetrofitAPI
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BusquedaRepository {

    fun createResultList() : List<Result>{
        return listOf<Result>(
            Result("Andrei","10-20-51",1000),
            Result("Prueba", "20-15-98", 5000)
        )
    }

    fun searchData(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://hn.algolia.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val RetrofitAPI = retrofit.create(RetrofitAPI::class.java)

        val results = RetrofitAPI.results()

        results.enqueue(object : Callback<List<Result>>{
            override fun onFailure(call: Call<List<Result>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<List<Result>>, response: Response<List<Result>>) {
                TODO("Not yet implemented")
            }

        })
    }
}