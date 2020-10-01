package com.example.lecturenotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteItemViewHolder>() {
    private var data = emptyList<Note>()

    inner class NoteItemViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.note_item, parent, false) as TextView
        return NoteItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {
        holder.textView.text = data[position].title
        holder.textView.setOnClickListener { view: View ->
            val bundle = bundleOf("noteTitle" to data[position].title)
            view.findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
        }
    }

    override fun getItemCount() = data.size

    fun setData(values: List<Note>) {
        data = values
        notifyDataSetChanged()
    }
}