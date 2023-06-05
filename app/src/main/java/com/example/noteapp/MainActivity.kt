package com.example.noteapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.noteapp.Database.RoomDB
import com.example.noteapp.Entity.NotesEntity
import com.example.noteapp.databinding.ActivityMainBinding
import com.example.noteapp.databinding.AddDialogBinding
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {
    lateinit var db:RoomDB
    lateinit var binding: ActivityMainBinding
    lateinit var apapter: NotesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = RoomDB.init(this)

        initView()
    }

    private fun initView() {
        binding.add.setOnClickListener {
        addNotesDialog()
        }
        apapter = NotesAdapter(db.note().getNotes())
        binding.noteList.layoutManager=GridLayoutManager(this,2)
        binding.noteList.adapter =apapter
    }

    private fun addNotesDialog() {
        var dialog= Dialog(this)
        var bind =AddDialogBinding.inflate(layoutInflater)
        dialog.setContentView(bind.root)

        bind.btnSubmit.setOnClickListener {
            var title =bind.edtTitle.text.toString()
            var text = bind.edttText.text.toString()
            var format=SimpleDateFormat("DD/MM/yyyy hh:mm:ss a")
            var current = format.format(Date())
            var data=NotesEntity(title,text,current)
            db.note().addNotes(data)
            apapter.update(db.note().getNotes())
            dialog.dismiss()

        }
        dialog.show()
    }
}