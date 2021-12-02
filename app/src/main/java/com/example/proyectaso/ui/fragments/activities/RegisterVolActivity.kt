package com.example.proyectaso.ui.fragments.activities

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.proyectaso.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import java.util.*

class RegisterVolActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_vol)

        val etNombUsu: EditText = findViewById(R.id.etNombUsu)
        val etNombComp: EditText = findViewById(R.id.etNombComp)
        val etCorreo: EditText = findViewById(R.id.etCorreoEleVol)
        val etTelefonoVol: EditText = findViewById(R.id.etTelefonoVol)
        val etContraVol: EditText = findViewById(R.id.etContraAusp)
        val cbTermAndCondVol: CheckBox = findViewById(R.id.cbTermCondVol)

        val ibRegresar2: ImageButton = findViewById(R.id.ibRegresar2)
        val btnRegistrarVol: Button = findViewById(R.id.btnRegistrarVol)

        val db = FirebaseFirestore.getInstance()

        auth = Firebase.auth

        btnRegistrarVol.setOnClickListener {
            var usuario = etNombUsu.text.toString()
            var nombre = etNombComp.text.toString()
            var correo = etCorreo.text.toString()
            var telefono = etTelefonoVol.text.toString()
            var contra = etContraVol.text.toString()

            var terminos = cbTermAndCondVol.text.toString()

            val nuevoVol = voluntario(contra, correo, nombre, telefono, usuario)

            val id: UUID = UUID.randomUUID()

            db.collection("voluntario") //voluntario es el nombre del campo en firebase

                .document(id.toString())
                .set(nuevoVol)
                .addOnSuccessListener {

                    auth.createUserWithEmailAndPassword(correo, contra)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information

                                Log.d(ContentValues.TAG, "createUserWithEmail:success")
                                val user = auth.currentUser
                                updateUI(user)
                            }
                        }
                    Toast.makeText(
                        applicationContext,
                        "Se registro correctamente",
                        Toast.LENGTH_LONG
                    ).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
                .addOnFailureListener {
                    Toast.makeText(applicationContext, "Ocurrio un problema", Toast.LENGTH_LONG)
                        .show()
                }
        }

        ibRegresar2.setOnClickListener{
            val intent = Intent(this, ChooseActivity::class.java)
            startActivity(intent)
        }

    }
}

data class voluntario(
    val contraseña: String,
    val correo: String,
    val nombre: String,
    val telefono: String,
    val usuario: String)

private fun updateUI(user: FirebaseUser?) {

}
