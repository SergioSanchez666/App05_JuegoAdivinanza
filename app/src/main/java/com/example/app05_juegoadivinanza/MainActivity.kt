package com.example.app05_juegoadivinanza

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app05_juegoadivinanza.ui.theme.App05_JuegoAdivinanzaTheme

class MainActivity : ComponentActivity() {
    private lateinit var textViewPregunta: TextView
    private lateinit var editTextRespuesta: EditText
    private lateinit var buttonEnviar: Button
    private lateinit var textViewResultado: TextView
    private val preguntas = mapOf(
        "¿Cuál es la capital de Francia?" to "París",
        "¿Cuál es el río más largo del mundo?" to "Nilo",
        "¿Cuántos continentes hay?" to "7"
    )
    private var preguntaActual: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView (R.layout.activity_main)

        textViewPregunta = findViewById(R.id.textViewPregunta)
        editTextRespuesta = findViewById (R.id.editTextRespuesta)

        buttonEnviar = findViewById(R.id.buttonEnviar)
        textViewResultado = findViewById (R.id.textViewResultado)

        mostrarPregunta()

        buttonEnviar.setOnClickListener {
            val respuesta = editTextRespuesta.text.toString()
            if (respuesta.equals(preguntas[preguntaActual], ignoreCase = true)) {
            textViewResultado.text = "¡Correcto!"
        } else {
            textViewResultado.text = "Incorrecto. La respuesta es ${preguntas[preguntaActual]}"
        }
            mostrarPregunta ()
        }
    }

    private fun mostrarPregunta() {
        val listaPreguntas =
            preguntas.keys.toList()
        preguntaActual = listaPreguntas . random ()
        textViewPregunta . text = preguntaActual
        editTextRespuesta.text.clear()
    }
}