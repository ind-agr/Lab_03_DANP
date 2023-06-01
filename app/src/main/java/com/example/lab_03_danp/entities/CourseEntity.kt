package com.example.lab_03_danp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CourseEntity(
    @PrimaryKey(autoGenerate = true)
    val courseId : Int,
    val courseName: String
    )