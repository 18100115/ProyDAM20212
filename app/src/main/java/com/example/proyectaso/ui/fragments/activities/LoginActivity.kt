package com.example.proyectaso.ui.fragments.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import com.example.proyectaso.R
import com.example.proyectaso.ui.fragments.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    lateinit var auth:FirebaseAuth
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

        auth = Firebase.auth

        btnLogin.setOnClickListener {
            var correo: String = etCorreo.text.toString()
            var clave: String = etContra.text.toString()


            if (correo.isNotEmpty()&&clave.isNotEmpty()) {
                auth.signInWithEmailAndPassword(correo, clave)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Log.d(TAG, "signInWithEmail:success")
                            Toast.makeText(this, "Inicio Satisfactorio", Toast.LENGTH_LONG).show()

                            val user = auth.currentUser
                            updateUI(user)

                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            updateUI(null)
                            Log.w(TAG, "signInWithEmail:failure", task.exception)
                            Toast.makeText(this,"El correo y/o clave es incorrecto",Toast.LENGTH_LONG).show()
                        }

                    }
            }else{
                Toast.makeText(this,"Ingrese los campos",Toast.LENGTH_LONG).show()
            }
        }
        btnRegister.setOnClickListener {
            val intent = Intent(this, ChooseActivity::class.java)
            startActivity(intent)
        }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            reload();
        }
    }

    private fun reload() {

    }
    private fun updateUI(user: FirebaseUser?) {

    }
    companion object {
        private const val TAG = "EmailPassword"
    }
}

