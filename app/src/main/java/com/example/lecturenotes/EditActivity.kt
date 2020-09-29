package com.example.lecturenotes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lecturenotes.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra("NOTE_TITLE")
        binding.editNoteTitle.setText(title)
        binding.saveButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("NOTE_TITLE", binding.editNoteTitle.text.toString())
            setResult(100, intent)
            finish()
        }
    }
}