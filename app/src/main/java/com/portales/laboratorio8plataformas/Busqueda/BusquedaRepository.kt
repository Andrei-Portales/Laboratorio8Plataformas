package com.portales.laboratorio8plataformas.Busqueda

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.DefaultRetryPolicy
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.portales.laboratorio8plataformas.Models.Result
import com.portales.laboratorio8plataformas.Models.RetrofitAPI
import okhttp3.Request
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class BusquedaRepository() {


    fun createResultList() : List<Result>{
        return listOf<Result>(
            Result("Andrei","10-20-51",1000, "","www.facebook.com"),
            Result("Prueba", "20-15-98", 5000, "","www.gmail.com")
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
                Log.d("RESPONSE DE INTERNET", t.message)
            }

            override fun onResponse(call: Call<List<Result>>, response: Response<List<Result>>) {
                if (response.isSuccessful){
                    Log.d("Respuesta", response.body().toString())
                }
            }

        })
    }

}