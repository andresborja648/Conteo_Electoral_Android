package com.example.conteoelectoral

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ConteoElectoral : AppCompatActivity() {
    private var votesCandidate1 = 0
    private var votesCandidate2 = 0
    private var votesCandidate3 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conteo_electoral)

        val etAge = findViewById<EditText>(R.id.etAge)
        val btnCandidate1 = findViewById<Button>(R.id.btnCandidate1)
        val btnCandidate2 = findViewById<Button>(R.id.btnCandidate2)
        val btnCandidate3 = findViewById<Button>(R.id.btnCandidate3)
        val btnFinishVoting = findViewById<Button>(R.id.btnFinishVoting)

        // Evento para votar por el Candidato 1
        btnCandidate1.setOnClickListener {
            val age = etAge.text.toString().toIntOrNull()
            if (validateAge(age)) {
                votesCandidate1++
                Toast.makeText(this, "Votaste por el Candidato 1", Toast.LENGTH_SHORT).show()
                etAge.text.clear() // Limpiar el EditText
            }
        }

        // Evento para votar por el Candidato 2
        btnCandidate2.setOnClickListener {
            val age = etAge.text.toString().toIntOrNull()
            if (validateAge(age)) {
                votesCandidate2++
                Toast.makeText(this, "Votaste por el Candidato 2", Toast.LENGTH_SHORT).show()
                etAge.text.clear() // Limpiar el EditText
            }
        }

        // Evento para votar por el Candidato 3
        btnCandidate3.setOnClickListener {
            val age = etAge.text.toString().toIntOrNull()
            if (validateAge(age)) {
                votesCandidate3++
                Toast.makeText(this, "Votaste por el Candidato 3", Toast.LENGTH_SHORT).show()
                etAge.text.clear() // Limpiar el EditText
            }
        }

        // Finalizar votación y mostrar resultados
        btnFinishVoting.setOnClickListener {
            val winner = determineWinner()
            Toast.makeText(this, winner, Toast.LENGTH_LONG).show()
        }
    }

    // Validar si el votante es mayor de edad
    private fun validateAge(age: Int?): Boolean {
        return if (age != null && age >= 18) {
            true
        } else {
            Toast.makeText(this, "Debes ser mayor de 18 años para votar", Toast.LENGTH_SHORT).show()
            false
        }
    }

    // Determinar el ganador de las elecciones
    private fun determineWinner(): String {
        return when {
            votesCandidate1 > votesCandidate2 && votesCandidate1 > votesCandidate3 -> {
                "El Candidato 1 ganó con $votesCandidate1 votos"
            }
            votesCandidate2 > votesCandidate1 && votesCandidate2 > votesCandidate3 -> {
                "El Candidato 2 ganó con $votesCandidate2 votos"
            }
            votesCandidate3 > votesCandidate1 && votesCandidate3 > votesCandidate2 -> {
                "El Candidato 3 ganó con $votesCandidate3 votos"
            }
            else -> "Hubo un empate en las elecciones"
        }
    }
}
