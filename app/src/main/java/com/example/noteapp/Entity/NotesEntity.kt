package com.example.noteapp.Entity

import android.service.quicksettings.Tile
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity(tableName = "Notes")
data class NotesEntity(
        @ColumnInfo(name = "title") var tilel:String,
        @ColumnInfo(name = "text") var text:String,
        @ColumnInfo(name = "Date") var Date:String,
    ){
        @PrimaryKey(autoGenerate = true) var id:Int=0
    }

