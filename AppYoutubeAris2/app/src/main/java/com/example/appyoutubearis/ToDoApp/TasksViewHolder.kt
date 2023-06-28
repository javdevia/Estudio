package com.example.appyoutubearis.ToDoApp

import android.content.res.ColorStateList
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.appyoutubearis.R

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvTasks: TextView = view.findViewById(R.id.tvTasks)
    private val cbTasks: CheckBox = view.findViewById(R.id.cbTasks)

    fun render(task: Task) {

        if (task.isSelected) {
            tvTasks.paintFlags = tvTasks.paintFlags or STRIKE_THRU_TEXT_FLAG
        }else{
            tvTasks.paintFlags = tvTasks.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }

        tvTasks.text = task.name
        cbTasks.isChecked =task.isSelected

        val color = when (task.category){
            TaskCategories.Business -> R.color.todo_business_category

            TaskCategories.Other -> R.color.todo_other_category

            TaskCategories.Personal -> R.color.todo_personal_category
        }
        cbTasks.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(cbTasks.context, color)
        )


    }
}