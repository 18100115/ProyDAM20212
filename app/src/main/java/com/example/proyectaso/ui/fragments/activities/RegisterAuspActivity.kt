package com.example.proyectaso.ui.fragments.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.proyectaso.R
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class RegisterAuspActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_ausp)

        val etRazSoc: EditText = findViewById(R.id.etRazSoc)
        val etNombRepre: EditText = findViewById(R.id.etNombRepre)
        val etCorreoEleAusp: EditText = findViewById(R.id.etCorreoEleAusp)
        val etTelefonoAusp: EditText = findViewById(R.id.etTelefonoAusp)
        val etContraAusp: EditText = findViewById(R.id.etContraAusp)
        val cbTermCondAusp: CheckBox = findViewById(R.id.cbTermCondAusp)
        val ibRegresar3: ImageButton = findViewById(R.id.ibRegresar3)
        val btnRegistrarAusp: Button = findViewById(R.id.btnRegistrarAusp)

        val db = FirebaseFirestore.getInstance()



        btnRegistrarAusp.setOnClickListener{
            var razonSoc= etRazSoc.text.toString()
            var nombreAusp = etNombRepre.text.toString()
            var correoAusp = etCorreoEleAusp.text.toString()
            var telefAusp = etTelefonoAusp.text.toString()
            var contraAusp = etContraAusp.text.toString()
            var terminos = cbTermCondAusp.text.toString()

            val nuevoauspiciador = auspiciador(razonSoc,nombreAusp,correoAusp,telefAusp,contraAusp)

            val id: UUID = UUID.randomUUID()

            db.collection("auspiciador") //auspiciador es el nombre del campo en firebase
                .document(id.toString())
                .set(nuevoauspiciador)
                .addOnSuccessListener {
                    Toast.makeText(applicationContext,"Se registro correctamente",Toast.LENGTH_LONG).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
                .addOnFailureListener{
                    Toast.makeText(applicationContext,"Ocurrio un problema",Toast.LENGTH_LONG).show()
                }

        }

        ibRegresar3.setOnClickListener{
            val intent = Intent(this, ChooseActivity::class.java)
            startActivity(intent)
        }

    }
}
data class auspiciador(
    val Contraseña: String,
    val NombreRep: String,
    val Telefono: String,
    val RazonSocial: String,
    val Correo: String)