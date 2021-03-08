package com.percobaan.tugasch6toprecycleview.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.percobaan.tugasch6toprecycleview.Model.MyNote
import com.percobaan.tugasch6toprecycleview.databinding.ListItemBinding

class MyAdapter (val data: List<MyNote>):RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    lateinit var onClick: (MyNote) -> Unit
    lateinit var onDeleteClick: (Int?) -> Unit
    lateinit var onEditClick :(MyNote) -> Unit

    fun setOnClickListener(onClick : (MyNote) -> Unit){
        this.onClick = onClick
    }
    fun setOnDeleteListerner(onClick : (Int?) -> Unit){
        this.onDeleteClick = onClick
    }
    fun setOnClickListerner(onClick : (MyNote) -> Unit){
        this.onEditClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = ListItemBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    inner class ViewHolder(var binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindViewHolder(note: MyNote) {
            binding.btnEdit.setOnClickListener {
                onEditClick(note)
            }
            binding.btnDelete.setOnClickListener {
                onDeleteClick(note.umur)
            }
            binding.tvNama.text = note.nama
            binding.tvUmur.text = note.umur.toString()
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(data[position])
    }

    override fun getItemCount(): Int = data.size

}