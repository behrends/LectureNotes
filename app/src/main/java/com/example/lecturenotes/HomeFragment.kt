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
        adapter.setData(listOf("Notiz 1", "Bemerkung", "Bitte Beachten"))
        return binding.root
    }
}