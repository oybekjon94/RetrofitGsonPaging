package com.example.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.databinding.ItemLayoutBinding

class TodoDiff : DiffUtil.ItemCallback<Todo>() {
    override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem == newItem
    }

}

class TodoAdapter : ListAdapter<Todo, TodoAdapter.TodoViewHolder>(TodoDiff()) {
    inner class TodoViewHolder(val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: Todo) {
            binding.titleTv.text = todo.title
            binding.checkBox.isChecked = todo.completed
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}