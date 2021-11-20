package com.example.proyectaso.ui.fragments.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import com.example.proyectaso.R

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

        btnRegistrarAusp.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        ibRegresar3.setOnClickListener{
            val intent = Intent(this, ChooseActivity::class.java)
            startActivity(intent)
        }

    }
}