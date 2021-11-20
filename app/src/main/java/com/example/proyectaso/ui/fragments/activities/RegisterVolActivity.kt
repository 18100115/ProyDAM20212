package com.example.proyectaso.ui.fragments.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import com.example.proyectaso.R

class RegisterVolActivity : AppCompatActivity() {
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

        btnRegistrarVol.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        ibRegresar2.setOnClickListener{
            val intent = Intent(this, ChooseActivity::class.java)
            startActivity(intent)
        }

    }
}