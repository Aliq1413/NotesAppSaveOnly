package com.example.notesapp_save_only
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp_save_only.databinding.ItemRowBinding
class RVAdapter :RecyclerView.Adapter<RVAdapter.ItemViewHolder>(){
    private  var notes = emptyList<Notes>()
    class ItemViewHolder(val  binding: ItemRowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return  ItemViewHolder(
            ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val note = notes[position]
        holder.binding.apply {
            val dataNote = "${note.pk} - ${note.noteName}"
            noteTv.text = dataNote
        }
    }

    override fun getItemCount() = notes.size
    fun updateNote(notes: ArrayList<Notes>){
        this.notes = notes
        notifyDataSetChanged()
    }

    }
