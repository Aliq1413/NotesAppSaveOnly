package com.example.notesapp_save_only
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity : AppCompatActivity() {
    lateinit var saveButton: Button
    lateinit var readButton: Button

    lateinit var edText: EditText
    lateinit var rvMain: RecyclerView
    lateinit var recyclerView: RVAdapter
    private lateinit var notes: ArrayList<Notes>
    private val databaseHelper by lazy { DatabaseHelper(applicationContext) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "My Note"
        notes = arrayListOf()
        saveButton = findViewById(R.id.btSave)
        edText = findViewById(R.id.edText)
        saveButton.setOnClickListener {
            val note = edText.text.toString()
            databaseHelper.saveNote(note)
            Toast.makeText(this, "Added successfully", Toast.LENGTH_LONG).show()
        }
        readButton = findViewById(R.id.btRead)
        readButton.setOnClickListener {
            notes = databaseHelper.fetchNote()
            recyclerView.updateNote(notes)
        }
        rvMain = findViewById(R.id.rV)
        recyclerView = RVAdapter()
        rvMain.adapter = recyclerView
        rvMain.layoutManager = LinearLayoutManager(this)


    }

}