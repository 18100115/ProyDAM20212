package com.example.proyectaso.ui.fragments

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.proyectaso.R
import com.example.proyectaso.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tipo = intent.getStringExtra("param")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Se valida el perfil
        if (tipo == "Voluntario"){
            val navView: BottomNavigationView = binding.navView
            val navController = findNavController(R.id.nav_host_fragment_activity_main)
            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            val appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.navactividades, R.id.navtienda, R.id.navhorario, R.id.navperfil
                )
            )
            setupActionBarWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)
        }else if (tipo == "Auspiciador"){
            val navView2: BottomNavigationView = binding.navView2
            val navController = findNavController(R.id.nav_host_fragment_activity_main)
            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            val appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.navactividades2, R.id.navperfil2
                )
            )
            setupActionBarWithNavController(navController, appBarConfiguration)
            navView2.setupWithNavController(navController)
        }



    }
}