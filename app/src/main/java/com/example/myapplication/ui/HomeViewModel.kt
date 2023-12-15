package com.example.myapplication.ui

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.model.ToDo
import com.example.myapplication.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val toDoRepository:ToDoRepository):ViewModel() {
    fun addTodo(todo:ToDo){
        toDoRepository.insert(todo)
    }
}