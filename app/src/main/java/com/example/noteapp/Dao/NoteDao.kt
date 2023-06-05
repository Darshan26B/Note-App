package com.example.noteapp.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.noteapp.Entity.NotesEntity

@Dao
interface NoteDao {

    @Insert
    fun addNotes(notesEntity: NotesEntity)

    @Query("SELECT * FROM notes")
    fun getNotes():List<NotesEntity>

    @Update
    fun updateNotes(notesEntity: NotesEntity)

    @Delete
    fun deleteNotes(notesEntity: NotesEntity)

    @Query("DELETE FROM notes")
    fun allDelete()
}