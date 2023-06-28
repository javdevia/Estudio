package com.example.appyoutubearis.ToDoApp

sealed class TaskCategories(var isSelected: Boolean = true) {
    object Personal : TaskCategories()
    object Business : TaskCategories()
    object Other : TaskCategories()
}