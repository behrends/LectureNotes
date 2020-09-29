package com.example.lecturenotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lecturenotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // setContentView(R.layout.activity_main)
        binding.button2.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra("NOTE_TITLE", binding.textView4.text)
            startActivityForResult(intent, 10)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val title = data?.getStringExtra("NOTE_TITLE")
        val text = "rqCode:" + requestCode + " - resCode: " + resultCode + " - " + title
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}