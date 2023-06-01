package com.example.lab_03_danp.model

import androidx.lifecycle.LiveData
import com.example.lab_03_danp.entities.CourseEntity
import com.example.lab_03_danp.entities.StudentEntity
import com.example.lab_03_danp.entities.relations.StudentCourseCrossRef

class Repository(private val courseDao: CourseDao, private val studentDao: StudentDao ) {

    val allCourse  : LiveData<List<CourseEntity>> = courseDao.getAllCourses()
    val allStudent  : LiveData<List<StudentEntity>> = studentDao.getAllStudents()
    val allCourseWithStudent  : LiveData<List<StudentCourseCrossRef>> = courseDao.getAllStudentCourseCrossRef()


    suspend fun addStudentCourseCrossRef(crossRef: StudentCourseCrossRef){
        courseDao.insertStudentCourseCrossRef(crossRef)
    }

    suspend fun addStudent(student: StudentEntity ){
        studentDao.insertStudent(student)
    }

    suspend fun  updateItem(student: StudentEntity ){
        studentDao.updateStudent(student)
    }

    suspend fun deleteItem(student: StudentEntity ){
        studentDao.deleteStudent(student)
    }

    suspend fun addCourse(course: CourseEntity){
        courseDao.insertCourse(course)
    }

    suspend fun  updateItem(course: CourseEntity){
        courseDao.updateCourse(course)
    }

    suspend fun deleteItem(course: CourseEntity){
        courseDao.deleteCourse(course)
    }

}