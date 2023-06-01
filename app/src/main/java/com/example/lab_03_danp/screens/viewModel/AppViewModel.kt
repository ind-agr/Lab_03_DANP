package com.example.lab_03_danp.screens.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.lab_03_danp.entities.CourseEntity
import com.example.lab_03_danp.entities.StudentEntity
import com.example.lab_03_danp.entities.relations.StudentCourseCrossRef
import com.example.lab_03_danp.model.AppDataBase
import com.example.lab_03_danp.model.Repository
import kotlinx.coroutines.launch

class AppViewModel (application: Application) : AndroidViewModel(application) {
    private val allCourseData : LiveData<List<CourseEntity>>
    private val allStudentData : LiveData<List<StudentEntity>>
    private val allStudentCourseCrossRef : LiveData<List<StudentCourseCrossRef>>
    private val repository : Repository
    init {
        val database = AppDataBase.getInstance(application)
        val courseDao = database.courseDao
        val studentDao = database.studentDao
        repository = Repository(courseDao, studentDao)
        allCourseData = repository.allCourse
        allStudentData = repository.allStudent
        allStudentCourseCrossRef = repository.allCourseWithStudent
    }

    fun getAllStudentCourseCrossRef(): LiveData<List<StudentCourseCrossRef>> {
        return allStudentCourseCrossRef
    }

    fun getAllCourse(): LiveData<List<CourseEntity>> {
        return allCourseData
    }
    fun addCourse(course: CourseEntity){
        viewModelScope.launch {
            repository.addCourse(course)
        }
    }

    fun addStudentCourseCrossRef(crossRef: StudentCourseCrossRef ){
        viewModelScope.launch {
            repository.addStudentCourseCrossRef(crossRef)
        }
    }

    fun getAllStudent() : LiveData<List<StudentEntity>> {
        return allStudentData
    }
    fun addStudent(student: StudentEntity){
        viewModelScope.launch {
            repository.addStudent(student)
        }
    }
}