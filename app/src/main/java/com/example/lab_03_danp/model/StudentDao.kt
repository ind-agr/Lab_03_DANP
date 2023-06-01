package com.example.lab_03_danp.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.lab_03_danp.entities.StudentEntity
import com.example.lab_03_danp.entities.relations.StudentWithCourse

@Dao
interface StudentDao {
    @Query("SELECT * from StudentEntity")
    fun getAllStudents(): LiveData<List<StudentEntity>>

    @Query("SELECT * from StudentEntity WHERE StudentId = :studentId")
    fun getStudent(studentId: Int): StudentEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertStudent(student: StudentEntity)

    @Update
    suspend fun updateStudent(student: StudentEntity)

    @Delete
    suspend fun deleteStudent(student: StudentEntity)

    @Transaction
    @Query("SELECT * FROM StudentEntity WHERE StudentId = :StudentId")
    fun getStudentWithCourse(StudentId : Int): LiveData<List<StudentWithCourse>>

}