package com.example.notesapp_save_only

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class DatabaseHelper(context:Context) : SQLiteOpenHelper(context,"notes.db", null,  2){
    private val  sqLiteDatabase:SQLiteDatabase = writableDatabase
    override fun onCreate(db: SQLiteDatabase?) {
            db?.execSQL("create table notes(pk INTEGER PRIMARY KEY AUTOINCREMENT, Note text)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS notes")
                 onCreate(db)    }

    fun saveNote(note: String){
        val  contentValues = ContentValues()
        contentValues.put("Note",note)
        sqLiteDatabase.insert("notes",null,contentValues)
    }
    fun fetchNote():ArrayList<Notes>{
        val  notes = arrayListOf<Notes>()
        val  cursor:Cursor = sqLiteDatabase.rawQuery("SELECT * FROM  notes", null)
        if (cursor.count < 1 ){
            println("no data")
        }else{
            while (cursor.moveToNext()){
                val  pk = cursor.getInt(0)
                val  noteName = cursor.getString(1)
                notes.add(Notes(pk,noteName))

            }
        }
        return notes
    }

}
