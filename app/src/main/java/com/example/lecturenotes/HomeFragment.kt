package com.example.lecturenotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        view.findViewById<Button>(R.id.button1).setOnClickListener {
            val bundle = bundleOf("noteTitle" to "Notiz1") // TODO tatsächlicher Titel
            view.findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
        }
        return view
    }
}