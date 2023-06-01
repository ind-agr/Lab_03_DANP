package com.example.lab_03_danp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StudentEntity(
    @PrimaryKey(autoGenerate = false)
    val studentId: Int,
    val studentName: String,
    val studentCod: String,
)