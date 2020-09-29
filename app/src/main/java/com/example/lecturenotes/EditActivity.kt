package com.example.lecturenotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        val title = intent.getStringExtra("NOTE_TITLE")
        findViewById<EditText>(R.id.editNoteTitle).setText(title)
    }
}