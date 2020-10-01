package com.example.lecturenotes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    var title: String,
    var text: String,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
)