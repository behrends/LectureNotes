package com.example.lecturenotes

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getNotes(): List<Note>

    @Insert
    suspend fun insert(note: Note)
}