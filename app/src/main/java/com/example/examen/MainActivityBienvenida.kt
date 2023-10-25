package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivityBienvenida : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bienvenida)

        val user = intent.getSerializableExtra("USER") as? persona
        if (user != null) {
            val mensaje = "Bienvenido, ${user.nombre} ${user.apellidos}!"
            val mensajetext = findViewById<TextView>(R.id.textView)
            mensajetext.text = mensaje
        }

        val btn2 = findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener{
            val intent = Intent(this@MainActivityBienvenida, MainActivity::class.java)
            startActivity(intent)
            finish() // Regresar al inicio de sesión
        }
       // binding.login.text = Editable.Factory.getInstance().newEditable("${nombre} ${apellidos}")

        }
    }


