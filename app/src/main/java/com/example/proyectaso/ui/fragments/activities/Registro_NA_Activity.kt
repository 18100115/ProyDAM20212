package com.example.proyectaso.ui.fragments.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.proyectaso.R
import com.example.proyectaso.ui.fragments.ActividadesFragment
import com.example.proyectaso.ui.fragments.MainActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class Registro_NA_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_na)
        // Codigo
        val txtNombreEvent: EditText = findViewById(R.id.edt_nombreE)
        val txtDescrip : EditText = findViewById(R.id.edt_desc)
        val txtUbic: EditText = findViewById(R.id.edt_ubic)
        val txtRecom: EditText = findViewById(R.id.edt_recom)
        val txtNvol: EditText = findViewById(R.id.edt_nvol)
        val txtFecha: EditText = findViewById(R.id.edt_fecha)
        val btnRegistroNA: Button = findViewById(R.id.btn_registroNA)
        val db = FirebaseFirestore.getInstance()




            btnRegistroNA.setOnClickListener {
                var nombre = txtNombreEvent.text.toString()
                var descripcion = txtDescrip.text.toString()
                var ubicacion = txtUbic.text.toString()
                var recompensa = txtRecom.text.toString()
                var num_voluntarios = txtNvol.text.toString()
                var fecha_hora = txtFecha.text.toString()

                val nuevoActividad = Actividad(
                    nombre,
                    descripcion,
                    ubicacion,
                    recompensa,
                    num_voluntarios,
                    fecha_hora
                )
                val id: UUID = UUID.randomUUID()

                db.collection("actividad")
                    .document(id.toString())
                    .set(nuevoActividad)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Registro Completado", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, ActividadesFragment::class.java)
                        startActivity(intent)
                    }.addOnFailureListener {
                        Toast.makeText(this, "Ocurrió un problema", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, ActividadesFragment::class.java)
                        startActivity(intent)
                    }


            }



    }
}

private fun enviarMensaje(vista: View ,mensaje:String){
    Snackbar.make(vista,mensaje,Snackbar.LENGTH_LONG).show()
}
data class Actividad(
    val nombre:String,
    val descripcion:String,
    val ubicacion:String,
    val recompensa:String,
    val num_voluntarios :String,
    val fecha_hora:String,
)