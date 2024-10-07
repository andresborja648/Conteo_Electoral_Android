package com.example.conteoelectoral

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Asignamos el layout a la actividad

        // Busca el botón en la vista por su ID
        val button = findViewById<Button>(R.id.myButton)

        // Configura la acción del botón cuando se hace clic
        button.setOnClickListener {
            Toast.makeText(this, "¡Botón presionado!", Toast.LENGTH_SHORT).show()
        }
    }
}
