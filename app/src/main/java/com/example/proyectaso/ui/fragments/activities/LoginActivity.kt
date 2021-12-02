package com.example.proyectaso.ui.fragments.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import com.example.proyectaso.R
import com.example.proyectaso.ui.fragments.MainActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //Pruebaaaaa
        val etCorreo: EditText = findViewById(R.id.etCorreo)
        val etContra: EditText = findViewById(R.id.etContra)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val btnRegister: Button = findViewById(R.id.btnRegister)
        val rgTipo: RadioGroup = findViewById(R.id.rgTipo)
        val db = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener {
            var correo: String = etCorreo.text.toString()
            var clave: String = etContra.text.toString()

            if (correo.isNotEmpty()&&clave.isNotEmpty()) {
                db.signInWithEmailAndPassword(correo, clave)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Inicio Satisfactorio", Toast.LENGTH_LONG).show()
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(
                                this,
                                "El correo y/o clave es incorrecto",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                    }
            }else{
                Toast.makeText(this,"Ingrese los campos",Toast.LENGTH_LONG).show()
            }
            btnRegister.setOnClickListener {
                val intent = Intent(this, ChooseActivity::class.java)
                startActivity(intent)
            }

        }
    }

}