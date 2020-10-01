package com.example.lecturenotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.lecturenotes.databinding.FragmentEditBinding

class EditFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEditBinding.inflate(layoutInflater)
        binding.saveButton.setOnClickListener { view: View ->
            val bundle = bundleOf("noteTitle" to binding.editNoteTitle.text.toString())
            view.findNavController().navigate(R.id.action_editFragment_to_detailFragment, bundle)
        }
        return binding.root
    }
}