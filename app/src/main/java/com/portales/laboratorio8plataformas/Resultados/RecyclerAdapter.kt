package com.portales.laboratorio8plataformas.Resultados

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.portales.laboratorio8plataformas.Models.Result
import com.portales.laboratorio8plataformas.R
import kotlinx.android.synthetic.main.resultado_model.view.*
import java.lang.Exception

class RecyclerAdapter (var context:Context, var lista: List<Result>) :RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
            var view = view

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(context).inflate(R.layout.resultado_model, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val element = lista.get(position)
        holder.view.txtTitulo.setText(element.title)
        holder.view.txtCreated.setText(element.created_at)
        holder.view.txtAuthor.setText(element.author)
        holder.view.txtPoints.setText(element.points.toString())
        holder.view.setOnClickListener {
            try {
                val uri = Uri.parse(element.url)
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = uri
                (context as Activity).startActivity(intent)
            }catch (e:Exception){
                Toast.makeText(context, "No se pudo abrir url", Toast.LENGTH_LONG).show()
            }
        }
    }

}