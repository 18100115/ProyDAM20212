package com.example.proyectaso.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectaso.R
import com.example.proyectaso.ui.fragments.activities.Actividad

class ActividadAdapter (private var lstActividad: List<Actividad>):RecyclerView.Adapter<ActividadAdapter.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val tvDescripcion: TextView = itemView.findViewById(R.id.tvDescripcion)
        val tvMonedas : TextView = itemView.findViewById(R.id.tvMonedas)
        val tvUbicacion : TextView = itemView.findViewById(R.id.tvUbica)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_actividad,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemActividad = lstActividad[position]
        holder.tvNombre.text = itemActividad.nombre
        holder.tvDescripcion.text = itemActividad.descripcion
        holder.tvMonedas.text = itemActividad.recompensa
        holder.tvUbicacion.text = itemActividad.ubicacion
    }

    override fun getItemCount(): Int {
        return  lstActividad.size
    }
}