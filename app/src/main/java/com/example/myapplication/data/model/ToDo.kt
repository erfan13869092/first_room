package com.example.myapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDo (@PrimaryKey(autoGenerate = true) val id:Int,val name:String)