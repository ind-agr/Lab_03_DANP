package com.example.lab_03_danp.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.lab_03_danp.entities.CourseEntity
import com.example.lab_03_danp.entities.StudentEntity

data class CourseWithStudents(
    @Embedded val course: CourseEntity,
    @Relation(
        parentColumn = "courseId",
        entityColumn = "studentId",
        associateBy = Junction(StudentCourseCrossRef::class)
    )
    val student: List<StudentEntity>
)