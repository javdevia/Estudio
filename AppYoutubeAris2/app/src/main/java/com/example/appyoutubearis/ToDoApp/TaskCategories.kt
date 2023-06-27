package com.example.appyoutubearis.ToDoApp

sealed class TaskCategories {
    object Personal : TaskCategories ()
    object Business : TaskCategories ()
    object Other : TaskCategories ()
}