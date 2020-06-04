package com.portales.laboratorio8plataformas.Busqueda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.portales.laboratorio8plataformas.R
import kotlinx.android.synthetic.main.fragment_busqueda.view.*

/**
 * A simple [Fragment] subclass.
 */
class BusquedaFragment : Fragment() {

    private lateinit var vista : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_busqueda, container, false)
        vista.btnBuscar.setOnClickListener {
            Navigation.findNavController(vista).navigate(R.id.action_busquedaFragment_to_resultadosFragment2)
        }

        return vista
    }

}
