package com.example.myapplication.data.repo

import com.example.myapplication.data.dao.ToDoDao
import com.example.myapplication.data.model.ToDo
import javax.inject.Inject

class ToDoRepositoryImpl @Inject constructor(private val toDoDao: ToDoDao) : ToDoRepository {
    override fun insert(toDo: ToDo) {
        toDoDao.insert(toDo)
    }

    override fun getTodo(): List<ToDo> = toDoDao.getTodo()

    override fun update(toDo: ToDo) {
        toDoDao.update(toDo)
    }

    override fun delete(toDo: ToDo) {
        toDoDao.delete(toDo)
    }

    override fun deleteAll() {
        toDoDao.deleteAll()
    }
}