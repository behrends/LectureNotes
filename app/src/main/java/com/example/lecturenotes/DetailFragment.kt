package com.example.lecturenotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.lecturenotes.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailBinding.inflate(layoutInflater)
        binding.button2.setOnClickListener {view: View ->
            view.findNavController().navigate(R.id.action_detailFragment_to_editFragment)
        }
        return binding.root
    }
}