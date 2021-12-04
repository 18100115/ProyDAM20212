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
import com.google.firebase.firestore.DocumentReference
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

        val et1: EditText = findViewById(R.id.etEditar1)
        val et2: EditText = findViewById(R.id.etEditar2)
        val et3: EditText = findViewById(R.id.etEditar3)
        val et4: EditText = findViewById(R.id.etEditar4)
        val et5: EditText = findViewById(R.id.etEditar5)


        val botonGuardar: Button = findViewById(R.id.btnEditarGuardar)
        auth = Firebase.auth

        val user = Firebase.auth.currentUser
        val uid = user!!.uid //Es importante, no borrar
        val db = Firebase.firestore
        //SOLO CAMBIA TEXT VIEW
        db.collection("voluntario")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    if ("${document.data["correo"]}"=="${user.email}"){
                        val persona = db.collection("voluntario").document("${document}")
                        tv1.text = "Nombre:"
                        tv2.text = "Usuario:"
                        tv3.text = "Telefono"
                        tv4.text = "Correo:"
                        tv5.text = "Contraseña"

                        break
                    }
                }
            }
        //SOLO CAMBIA TEXT VIEW
        db.collection("auspiciador")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    if ("${document.data["correo"]}"=="${user.email}"){
                        val persona = db.collection("auspiciador").document("${document}")
                        tv1.text = "Nombre Representante:"
                        tv2.text = "Razón social:"
                        tv3.text = "Telefono"
                        tv4.text = "Correo:"
                        tv5.text = "Contraseña"
                        break
                    }
                }
            }


        //UNA VEZ GUARDADO
        botonGuardar.setOnClickListener {

            db.collection("auspiciador")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        if ("${document.data["correo"]}"=="${user.email}"){
                            val persona = db.collection("auspiciador").document("${document}")
                            persona.update("nombreRep",et1.text)
                            persona.update("razonSocial",et2.text)
                            persona.update("telefono",et3.text)
                            persona.update("correo",et4.text)
                            persona.update("contraseña",et5.text)

                            break
                        }
                    }
                }

            db.collection("voluntario")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        if ("${document.data["correo"]}"=="${user.email}"){
                            val persona = db.collection("voluntario").document("${document}")
                            persona.update("nombre",et1.text)
                            persona.update("usuario",et2.text)
                            persona.update("telefono",et3.text)
                            persona.update("correo",et4.text)
                            persona.update("contraseña",et5.text)

                            break
                        }
                    }
                }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
