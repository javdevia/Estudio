package com.example.appyoutubearis.ToDoApp

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appyoutubearis.R

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvTasks: TextView = view.findViewById(R.id.tvTasks)
    private val cbTasks: CheckBox = view.findViewById(R.id.cbTasks)

    fun render(task: Task) {

        tvTasks.text = task.name


    }
}