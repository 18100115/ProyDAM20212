package com.example.proyectaso.ui.fragments.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.proyectaso.R
import com.example.proyectaso.ui.fragments.MainActivity
import com.example.proyectaso.ui.fragments.PerfilFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class EditProfileActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val tv1: TextView = findViewById(R.id.tvEditar1)
        val tv2: TextView = findViewById(R.id.tvEditar2)
        val tv3: TextView = findViewById(R.id.tvEditar3)
        val tv4: TextView = findViewById(R.id.tvEditar4)
        val tv5: TextView = findViewById(R.id.tvEditar5)

        val botonGuardar: Button = findViewById(R.id.btnEditarGuardar)
        val tipo = 0 //0 Es voluntario, 1 auspiciador
        auth = Firebase.auth

        val user = Firebase.auth.currentUser
        val uid = user!!.uid //Es importante, no borrar
        val db = Firebase.firestore

        db.collection("voluntario")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    if ("${document.data["correo"]}"=="${user.email}"){
                        tv1.text = "Nombre:"
                        tv2.text = "Usuario:"
                        tv3.text = "Telefono"
                        tv4.text = "Correo:"
                        tv5.text = "Contraseña"

                        break
                    }
                }
            }

        db.collection("auspiciador")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    if ("${document.data["correo"]}"=="${user.email}"){
                        tv1.text = "Nombre Representante:"
                        tv2.text = "Razón social:"
                        tv3.text = "Telefono"
                        tv4.text = "Correo:"
                        tv5.text = "Contraseña"
                        break
                    }
                }
            }

        botonGuardar.setOnClickListener {




            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}