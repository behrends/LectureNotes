package com.example.lecturenotes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lecturenotes.databinding.FragmentHomeBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
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

        val db = Firebase.firestore
        var index = 0L
        db.collection("notes").get()
            .addOnSuccessListener { result ->
                var notes = mutableListOf<Note>()
                for (note in result) {
                    Log.d("HOME_FRAGMENT", "${note.id} => ${note.data}")
                    // TODO Note data class soll ID-String haben --> verwende ID aus Cloud
                    val newNote = Note(note.data.get("title").toString(), note.data.get("text").toString(), index)
                    notes.add(newNote)
                    index++
                }
                adapter.setData(notes)
            }
            .addOnFailureListener { exception ->
                Log.w("HOME_FRAGMENT", "Error getting documents.", exception)
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