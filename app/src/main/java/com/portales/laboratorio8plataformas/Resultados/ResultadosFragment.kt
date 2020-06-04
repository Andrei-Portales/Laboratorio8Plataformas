package com.portales.laboratorio8plataformas.Resultados

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.portales.laboratorio8plataformas.MainActivity
import com.portales.laboratorio8plataformas.R
import kotlinx.android.synthetic.main.fragment_resultados.view.*

/**
 * A simple [Fragment] subclass.
 */
class ResultadosFragment : Fragment() {

    private lateinit var vista:View
    private lateinit var adapter: RecyclerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_resultados, container, false)
        adapter = RecyclerAdapter(context as Context, (activity as MainActivity).getLista())
        vista.recyclerView.setHasFixedSize(true)
        val llm = LinearLayoutManager(context);
        vista.recyclerView.setLayoutManager(llm)
        vista.recyclerView.adapter = adapter
        return vista
    }

}
