package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val usersList = arrayListOf(
        persona("Eduardo", "Hernandez", "Eduardo", "lalo"),
        persona("moises ", "calvario", "Moises","moy")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login = findViewById<EditText>(R.id.login)
        val password = findViewById<EditText>(R.id.contraseña)
        val enviar = findViewById<Button>(R.id.btn1)

        enviar.setOnClickListener {
            val enterlogin = login.text.toString()
            val enterpassword = password.text.toString()

            val user = usersList.find { it.username == enterlogin && it.password == enterpassword }

            if (user != null) {
                val intent = Intent(this@MainActivity, MainActivityBienvenida::class.java)
                intent.putExtra("USER", user)
                startActivity(intent)
            } else {
                Toast.makeText(this@MainActivity, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }

    }
}