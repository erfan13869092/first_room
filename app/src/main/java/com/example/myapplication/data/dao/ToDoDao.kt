package com.example.myapplication.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.data.model.ToDo

@Dao
interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(toDo: ToDo)

    @Query("SELECT * FROM todo")
    fun getTodo(): List<ToDo>

    @Update()
    fun update(toDo: ToDo)

    @Delete
    fun delete(toDo: ToDo)

    @Query("DELETE FROM todo")
    fun deleteAll()
}