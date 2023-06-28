package com.example.appyoutubearis.ToDoApp

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appyoutubearis.R
import com.example.appyoutubearis.ToDoApp.TaskCategories.Business
import com.example.appyoutubearis.ToDoApp.TaskCategories.Other
import com.example.appyoutubearis.ToDoApp.TaskCategories.Personal
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ToDoAppActivity : AppCompatActivity() {

    private val categories = listOf(
        Personal,
        Business,
        Other
    )

    private val tasks = mutableListOf(
        Task("PruebaBusiness", Business),
        Task("PruebaPersonal", Personal),
        Task("PruebaOther", Other),
    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvTasks: RecyclerView
    private lateinit var tasksAdapter: TasksAdapter

    private lateinit var fabAddTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_app)
        initComponent()
        initUI()
        initListeners()
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks)
        rvTasks.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvTasks.adapter = tasksAdapter


    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog (this)
        dialog.setContentView(R.layout.dialog_task)
        dialog.show()
    }
}