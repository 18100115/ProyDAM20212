package com.example.proyectaso.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectaso.R
import com.example.proyectaso.ui.fragments.activities.Actividad
import com.example.proyectaso.ui.fragments.activities.LoginActivity
import com.example.proyectaso.ui.fragments.activities.Registro_NA_Activity
import com.example.proyectaso.ui.fragments.adapter.ActividadAdapter
import com.google.firebase.firestore.DocumentChange
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


        db.collection("actividad")
            .addSnapshotListener{ snapshots,e->
                if(e!=null)
                {
                    Log.w("Firebase Warning", "error",e)
                    return@addSnapshotListener
                }

                for (dc in snapshots!!.documentChanges){
                    when(dc.type){
                        DocumentChange.Type.ADDED -> {
                            lstActividad.add(
                                Actividad(dc.document.data["nombre"].toString(),
                                    dc.document.data["descripcion"].toString(),
                                    dc.document.data["ubicacion"].toString(),
                                    dc.document.data["recompensa"].toString(),
                                    dc.document.data["num_voluntarios"].toString(),
                                    dc.document.data["fecha_hora"].toString()))
                            rvActividad.adapter = ActividadAdapter(lstActividad)
                        }
                        DocumentChange.Type.MODIFIED -> {
                            lstActividad.add(
                                Actividad(dc.document.data["nombre"].toString(),
                                    dc.document.data["descripcion"].toString(),
                                    dc.document.data["ubicacion"].toString(),
                                    dc.document.data["recompensa"].toString(),
                                    dc.document.data["num_voluntarios"].toString(),
                                    dc.document.data["fecha_hora"].toString()))
                            rvActividad.adapter = ActividadAdapter(lstActividad)
                        }
                        DocumentChange.Type.REMOVED -> {
                            Log.w("Firebase Warning","REMOVED")
                        }

                    }

                }

                rvActividad.layoutManager = LinearLayoutManager(requireContext())

            }


        btnAgregar.setOnClickListener{
            val intent = Intent(activity, Registro_NA_Activity::class.java)
            startActivity(intent)
        }


        return  view


    }


}