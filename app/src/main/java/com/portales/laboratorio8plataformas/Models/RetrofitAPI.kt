package com.portales.laboratorio8plataformas.Models

import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI {

    @GET("search")
    fun results(): Call<List<Result>>

}