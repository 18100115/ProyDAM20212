package com.example.proyectaso.ui.fragments.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.proyectaso.R

class ChooseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)
        //sadsadsda
        val ibEscVol: ImageButton = findViewById(R.id.ibEscVol)
        val ibEscAusp: ImageButton = findViewById(R.id.ibEscAusp)
        val ibRegresar1: ImageButton = findViewById(R.id.ibRegresar1)

        ibEscVol.setOnClickListener{
            val intent = Intent(this, RegisterVolActivity::class.java)
            startActivity(intent)
        }

        ibEscAusp.setOnClickListener{
            val intent = Intent(this, RegisterAuspActivity::class.java)
            startActivity(intent)
        }

        ibRegresar1.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}