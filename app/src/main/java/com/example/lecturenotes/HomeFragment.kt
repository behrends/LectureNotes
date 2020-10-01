package com.example.lecturenotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lecturenotes.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(layoutInflater)
        val adapter = NoteAdapter()
        binding.notesList.adapter = adapter

        val note1 = Note(1, "Notiz Nr. 1", "TODO...")
        val note2 = Note(2, "Bemerkung", "irgendwas")
        val note3 = Note(3, "Bitte Beachten", "super wichtig")
        val list = listOf(note1,note2,note3)
        adapter.setData(list)
        return binding.root
    }
}