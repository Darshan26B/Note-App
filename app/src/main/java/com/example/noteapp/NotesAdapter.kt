package com.example.noteapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.noteapp.Entity.NotesEntity
import com.example.noteapp.databinding.NoteItemBinding

class NotesAdapter(notes: List<NotesEntity>) :Adapter<NotesAdapter.NotesHolder>() {
   var notes=notes
    class NotesHolder(itemView: NoteItemBinding) : ViewHolder(itemView.root) {
        var binding=itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesHolder {
        var binding =NoteItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NotesHolder(binding)
    }

    override fun getItemCount(): Int {
         return notes.size
    }

    override fun onBindViewHolder(holder: NotesHolder, position: Int) {
         holder.binding.apply {
             txtTitle.isSelected=true
             notes.get(position).apply {
                 txtTitle.text = tilel
                 txtText.text = text
             }
         }
    }

    fun update(notes: List<NotesEntity>) {
                this.notes=notes
        notifyDataSetChanged()
    }

}