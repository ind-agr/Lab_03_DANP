package com.example.lab_03_danp.entities.relations

import androidx.room.Entity

@Entity(primaryKeys = ["studentId", "courseId"])
data class StudentCourseCrossRef (
    val studentId : Int,
    val courseId : Int
)