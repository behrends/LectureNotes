package com.example.lecturenotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lecturenotes.databinding.FragmentHomeBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(layoutInflater)
        val adapter = NoteAdapter()
        binding.notesList.adapter = adapter

        // DB-Verbindung herstellen und Dao initialisieren
        GlobalScope.async {
            val noteDao = AppDatabase.getDatabase(requireContext()).noteDao()
            val notes = noteDao.getNotes()
            adapter.setData(notes)
        }

        binding.buttonNewNote.setOnClickListener { view: View ->
            GlobalScope.async {
                val noteDao = AppDatabase.getDatabase(requireContext()).noteDao()
                noteDao.insert(Note("NEUE NOTIZ!", "EGAL"))
                val notes = noteDao.getNotes()
                adapter.setData(notes)
            }
        }
        return binding.root
    }
}