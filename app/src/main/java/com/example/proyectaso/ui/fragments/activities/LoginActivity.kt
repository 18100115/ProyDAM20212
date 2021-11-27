package com.example.proyectaso.ui.fragments.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import com.example.proyectaso.R
import com.example.proyectaso.ui.fragments.MainActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etCorreo: EditText = findViewById(R.id.etCorreo)
        val etContra: EditText = findViewById(R.id.etContra)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val btnRegister: Button = findViewById(R.id.btnRegister)
        val rgTipo: RadioGroup = findViewById(R.id.rgTipo)

        btnLogin.setOnClickListener{
            var messageDetail = rgTipo.toString()
            this.sendMessage(messageDetail)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnRegister.setOnClickListener{
            val intent = Intent(this, ChooseActivity::class.java)
            startActivity(intent)
        }

    }

    private fun sendMessage(message: String)
    {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("param", message)
        startActivity(intent)
    }
}