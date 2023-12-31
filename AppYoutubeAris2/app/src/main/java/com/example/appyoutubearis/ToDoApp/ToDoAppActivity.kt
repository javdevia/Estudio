package com.example.appyoutubearis.ToDoApp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
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
        categoriesAdapter = CategoriesAdapter(categories) { updateCategories(it) }
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks) { onItemSelected(it) }
        rvTasks.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvTasks.adapter = tasksAdapter
    }

    private fun onItemSelected(position: Int) {
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val etNewTask: EditText = dialog.findViewById(R.id.etNewTask)
        val rgNewTaskCategory: RadioGroup = dialog.findViewById(R.id.rgNewTaskCategories)
        val btnNewTaskComplete: Button = dialog.findViewById(R.id.btnNewTaskComplete)

        btnNewTaskComplete.setOnClickListener {

            val currentTask = etNewTask.text.toString()

            if (currentTask.isNotEmpty()) {
                val selectedId = rgNewTaskCategory.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgNewTaskCategory.findViewById(selectedId)
                val currentCategory: TaskCategories = when (selectedRadioButton.text.toString()) {
                    getString(R.string.todo_business) -> Business
                    getString(R.string.todo_personal) -> Personal
                    else -> Other
                }

                tasks.add(Task(currentTask, currentCategory))
                updateTasks()
                dialog.hide()
            }
        }
        dialog.show()
    }

    private fun updateCategories(position: Int) {
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()
    }

    private fun updateTasks() {
        val selectedCategories: List<TaskCategories> = categories.filter { it.isSelected }
        val newTasks= tasks.filter {selectedCategories.contains(it.category)}
        tasksAdapter.tasks = newTasks
        tasksAdapter.notifyDataSetChanged()
    }
}