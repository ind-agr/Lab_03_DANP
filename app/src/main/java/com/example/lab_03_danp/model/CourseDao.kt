package com.example.lab_03_danp.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.lab_03_danp.entities.CourseEntity
import com.example.lab_03_danp.entities.relations.CourseWithStudents
import com.example.lab_03_danp.entities.relations.StudentCourseCrossRef

@Dao
interface CourseDao {
    @Query("SELECT * from CourseEntity")
    fun getAllCourses(): LiveData<List<CourseEntity>>

    @Query("SELECT * from CourseEntity WHERE courseId = :courseId")
    fun getCourse(courseId: Int): CourseEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCourse(course: CourseEntity)

    @Update
    suspend fun updateCourse(course: CourseEntity)

    @Delete
    suspend fun deleteCourse(course: CourseEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertStudentCourseCrossRef(crossRef: StudentCourseCrossRef)

    @Query("SELECT * from StudentCourseCrossRef")
    fun getAllStudentCourseCrossRef() : LiveData<List<StudentCourseCrossRef>>

    @Transaction
    @Query("SELECT * FROM CourseEntity WHERE courseId = :courseId")
    fun getCourseWithStudent(courseId : Int): LiveData<List<CourseWithStudents>>
}