package com.example.myapplication.data.repo

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.data.model.ToDo

interface ToDoRepository {
    fun insert(toDo: ToDo)

    fun getTodo(): List<ToDo>

    fun update(toDo: ToDo)

    fun delete(toDo: ToDo)

    fun deleteAll()
}