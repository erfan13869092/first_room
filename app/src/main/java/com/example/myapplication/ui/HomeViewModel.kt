package com.example.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.model.ToDo
import com.example.myapplication.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val toDoRepository: ToDoRepository) : ViewModel() {

    private val _taskMutableLivaData: MutableLiveData<List<ToDo>> by lazy {
        MutableLiveData<List<ToDo>>()
    }
    val taskLivaData: LiveData<List<ToDo>> by lazy {
        _taskMutableLivaData
    }

    init {
        getTasks()
    }

    fun addTodo(todo: ToDo) {
        toDoRepository.insert(todo)
    }

    fun getTasks() {
        _taskMutableLivaData.value = toDoRepository.getTodo()
    }
}