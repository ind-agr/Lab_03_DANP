package com.example.lab_03_danp.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.lab_03_danp.entities.CourseEntity
import com.example.lab_03_danp.entities.StudentEntity

data class StudentWithCourse(
    @Embedded val student: StudentEntity,
    @Relation(
        parentColumn = "studentId",
        entityColumn = "courseId",
        associateBy = Junction(StudentCourseCrossRef::class)
    )
    val course: List<CourseEntity>
)