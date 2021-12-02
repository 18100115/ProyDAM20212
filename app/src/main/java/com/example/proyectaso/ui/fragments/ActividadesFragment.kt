package com.example.proyectaso.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.proyectaso.R

class ActividadesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_actividades, container, false)
        val btnAgregar: Button = view.findViewById(R.id.btn_AgregarAct)

        btnAgregar.setOnClickListener {

        }
        return  view


    }


}