package com.example.notesapp_save_only
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
class MainActivity : AppCompatActivity() {
    lateinit var saveButton :Button
    lateinit var edText :EditText
    private  val  databaseHelper by lazy { DatabaseHelper(applicationContext)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        saveButton = findViewById(R.id.btSave)
        edText = findViewById(R.id.edText)
        saveButton.setOnClickListener {
            val note = edText.text.toString()
            databaseHelper.saveNote(note)
            Toast.makeText(this,"Added successfully",Toast.LENGTH_LONG).show()
        }
    }
}