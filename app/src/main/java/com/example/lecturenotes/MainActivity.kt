package com.example.lecturenotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // finde den Button mit der ID button2 im UI
        val button = findViewById<Button>(R.id.button2)
        // setze einen Listener/Callback an den Button (Klickverhalten für Button)
        button.setOnClickListener {
            Toast.makeText(this, "Mit Listener!", Toast.LENGTH_LONG).show()
        }
    }
}