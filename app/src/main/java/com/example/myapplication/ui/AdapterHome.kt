package com.example.myapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.model.ToDo
import com.example.myapplication.databinding.LayoutAdapterBinding

class AdapterHome() : RecyclerView.Adapter<AdapterHome.ViewHolder>() {
    var task = ArrayList<ToDo>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(val binding: LayoutAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: ToDo) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = task.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(task[position])
    }
}