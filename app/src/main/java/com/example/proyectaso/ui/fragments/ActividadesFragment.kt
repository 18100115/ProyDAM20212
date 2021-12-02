package com.example.proyectaso.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectaso.R
import com.example.proyectaso.ui.fragments.activities.Actividad
import com.example.proyectaso.ui.fragments.activities.LoginActivity
import com.example.proyectaso.ui.fragments.activities.Registro_NA_Activity
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class ActividadesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_actividades, container, false)
        val btnAgregar: Button = view.findViewById(R.id.btn_AgregarAct)
        val db = FirebaseFirestore.getInstance()
        val lstActividad: ArrayList<Actividad> = ArrayList()
        val rvActividad: RecyclerView = view.findViewById(R.id.rcv_Lista_Actividades)



        btnAgregar.setOnClickListener{
            val intent = Intent(activity, Registro_NA_Activity::class.java)
            startActivity(intent)
        }


        return  view


    }


}