package com.example.notesapp_save_only

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context:Context) : SQLiteOpenHelper(context,"notes.db", null,  1){
    private val  sqLiteDatabase:SQLiteDatabase = writableDatabase
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null){
            db.execSQL("create table Notes (Note text)")
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {}
    fun saveNote(note: String){
        val  contentValues = ContentValues()
        contentValues.put("Note",note)
        sqLiteDatabase.insert("notes",null,contentValues)
    }

}
