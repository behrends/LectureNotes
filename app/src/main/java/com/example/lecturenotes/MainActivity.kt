package com.example.lecturenotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val title = findViewById<TextView>(R.id.textView4)
        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            Toast.makeText(this, "Mit Listener!", Toast.LENGTH_LONG).show()
            title.text = "TITEL GEÄNDERT"
        }
    }
}