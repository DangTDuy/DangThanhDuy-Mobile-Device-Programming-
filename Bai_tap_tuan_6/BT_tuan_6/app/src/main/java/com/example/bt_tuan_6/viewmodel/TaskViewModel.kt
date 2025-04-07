package com.example.bt_tuan_6.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.bt_tuan_6.data.model.Task

class TaskViewModel : ViewModel() {
    private val _tasks = mutableStateListOf<Task>()
    val tasks: List<Task> get() = _tasks

    fun addTask(task: Task) {
        val newId = if (_tasks.isEmpty()) 1 else _tasks.maxOf { it.id } + 1
        _tasks.add(task.copy(id = newId)) // Tạo ID mới cho task
    }
}