package com.example.proyectaso.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectaso.R
import com.example.proyectaso.ui.fragments.model.Tienda

class TiendaAdapter (private var lstProductos: List<Tienda>)
    :RecyclerView.Adapter<TiendaAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivProducto: ImageView = itemView.findViewById(R.id.ivProducto)
        val tvProducto: TextView = itemView.findViewById(R.id.tvProducto)
        val btnProducto: Button = itemView.findViewById(R.id.btnProducto)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TiendaAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_tienda, parent, false))
    }

    override fun onBindViewHolder(holder: TiendaAdapter.ViewHolder, position: Int) {
        val itemProducto = lstProductos[position]
        holder.tvProducto.text = itemProducto.producto
        holder.btnProducto.text = itemProducto.btncomprar.toString()
        holder.ivProducto.setImageResource(itemProducto.image)
    }

    override fun getItemCount(): Int {
        return lstProductos.size
    }
}