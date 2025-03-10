package com.example.app05_juegoadivinanza
//Miembros del equipo:
//Coronel Meza Sergio Daniel
//Sanchez Cruz Sergio Antonio

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
    /**
     * TextView para mostrar la pregunta actual.
     */
    private lateinit var textViewPregunta: TextView

    /**
     * EditText para que el usuario ingrese su respuesta.
     */
    private lateinit var editTextRespuesta: EditText

    /**
     * Botón para enviar la respuesta del usuario.
     */
    private lateinit var buttonEnviar: Button

    /**
     * TextView para mostrar el resultado (correcto o incorrecto).
     */
    private lateinit var textViewResultado: TextView

    /**
     * Mapa que contiene las preguntas y sus respuestas correctas.
     */
    private val preguntas = mapOf(
        "¿Cuál es la capital de Francia?" to "París",
        "¿Cuál es el río más largo del mundo?" to "Nilo",
        "¿Cuántos continentes hay?" to "7"
    )

    /**
     * Variable para almacenar la pregunta que se está mostrando actualmente.
     */
    private var preguntaActual: String = ""

    /**
     * Método llamado al crear la actividad.
     * Inicializa la vista, configura los listeners de los botones y muestra la primera pregunta.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa las vistas.
        textViewPregunta = findViewById(R.id.textViewPregunta)
        editTextRespuesta = findViewById(R.id.editTextRespuesta)
        buttonEnviar = findViewById(R.id.buttonEnviar)
        textViewResultado = findViewById(R.id.textViewResultado)

        // Muestra la primera pregunta.
        mostrarPregunta()

        // Configura el listener del botón enviar.
        buttonEnviar.setOnClickListener {
            val respuesta = editTextRespuesta.text.toString()
            if (respuesta.equals(preguntas[preguntaActual], ignoreCase = true)) {
                // Si la respuesta es correcta, muestra un mensaje de felicitación.
                textViewResultado.text = "¡Correcto!"
            } else {
                // Si la respuesta es incorrecta, muestra la respuesta correcta.
                textViewResultado.text = "Incorrecto. La respuesta es ${preguntas[preguntaActual]}"
            }
            // Muestra la siguiente pregunta.
            mostrarPregunta()
        }
    }

    /**
     * Selecciona una pregunta aleatoria del mapa de preguntas y la muestra en el TextView.
     * Limpia el EditText para que el usuario pueda ingresar una nueva respuesta.
     */
    private fun mostrarPregunta() {
        // Obtiene una lista de las claves (preguntas) del mapa.
        val listaPreguntas = preguntas.keys.toList()
        // Selecciona una pregunta aleatoria de la lista.
        preguntaActual = listaPreguntas.random()
        // Muestra la pregunta en el TextView.
        textViewPregunta.text = preguntaActual
        // Limpia el EditText.
        editTextRespuesta.text.clear()
    }
}