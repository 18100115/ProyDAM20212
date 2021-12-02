package com.example.proyectaso.ui.fragments

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.proyectaso.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.firestore

class PerfilFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_perfil, container, false)

        val correo: EditText = view.findViewById(R.id.tvCorreoPerfil)
        val nombre: EditText = view.findViewById(R.id.tvNombrePerfil)
        val telefono: EditText = view.findViewById(R.id.tvTelefonoPerfil)

        val botonEditar: Button = view.findViewById(R.id.btnPerfilEdit)

        auth = FirebaseAuth.getInstance()

        val currentUser = auth.currentUser
        val uid = currentUser!!.uid
        val db = Firebase.firestore

        db.collection("voluntario").document(uid).get().addOnSuccessListener {
            correo.text = (it.get("correo") as Editable?)
            nombre.text = (it.get("nombre") as Editable?)
            telefono.text = (it.get("telefono") as Editable?)

        }
        return view

    }
}

private  fun enviarMensaje(vista:View, mensaje: String){
    Snackbar.make(vista,mensaje,Snackbar.LENGTH_LONG).show()
}