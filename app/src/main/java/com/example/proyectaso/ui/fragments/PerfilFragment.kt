package com.example.proyectaso.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.proyectaso.R
import com.example.proyectaso.databinding.ActivityMainBinding
import com.example.proyectaso.ui.fragments.activities.ChooseActivity
import com.example.proyectaso.ui.fragments.activities.EditProfileActivity
import com.example.proyectaso.ui.fragments.activities.LoginActivity
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

        val correo: TextView = view.findViewById(R.id.tvCorreoPerfil)
        val nombre: TextView = view.findViewById(R.id.tvNombrePerfil)
        val telefono: TextView = view.findViewById(R.id.tvTelefonoPerfil)
        val tv4: TextView = view.findViewById(R.id.tv4)


        val botonEditar: Button = view.findViewById(R.id.btnPerfilEdit)
        val botonCerrarSesion: Button = view.findViewById(R.id.btnPerfilCerrarSesion)

        auth = Firebase.auth

        val user = Firebase.auth.currentUser
        val uid = user!!.uid //Es importante, no borrar
        val db = Firebase.firestore

        db.collection("voluntario")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    if ("${document.data["correo"]}"=="${user.email}"){
                        correo.text = "Correo: ${document.data["correo"]}"
                        nombre.text = "Nombre: ${document.data["nombre"]}"
                        telefono.text = "Telefono: ${document.data["telefono"]}"
                        tv4.text = "Usuario: ${document.data["usuario"]}"

                        break
                    }
                }
            }

        db.collection("auspiciador")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    if ("${document.data["correo"]}"=="${user.email}"){
                        correo.text = "Correo: ${document.data["correo"]}"
                        nombre.text = "Nombre: ${document.data["nombreRep"]}"
                        telefono.text = "Telefono: ${document.data["telefono"]}"
                        tv4.text = "Razón Social: ${document.data["razonSocial"]}"
                        break
                    }
                }
            }

        botonEditar.setOnClickListener {
            val intent = Intent(activity, EditProfileActivity::class.java)
            startActivity(intent)
        }

        botonCerrarSesion.setOnClickListener{
            auth.signOut()
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }

        return view

    }


}
