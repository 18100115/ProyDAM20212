package com.example.proyectaso.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectaso.R
import com.example.proyectaso.ui.fragments.adapter.TiendaAdapter
import com.example.proyectaso.ui.fragments.model.Producto


class TiendaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_tienda, container, false)
        val rvTienda: RecyclerView = view.findViewById(R.id.rvTienda)
        rvTienda.layoutManager = LinearLayoutManager(requireContext())
        rvTienda.adapter = TiendaAdapter(listProductoTienda())

        return view
    }

    private fun listProductoTienda(): List<Producto>{
        val lstProducto: ArrayList<Producto> = ArrayList()
        lstProducto.add(Producto(1,R.drawable.camisa, "Camisa Celeste",))
        lstProducto.add(Producto(2,R.drawable.zapatillas, "Zapatillas Rojas",))
        lstProducto.add(Producto(3,R.drawable.lentes, "Lentes de sol",))
        lstProducto.add(Producto(4,R.drawable.sombrero, "Sombrero PL",))

        return lstProducto
    }
}