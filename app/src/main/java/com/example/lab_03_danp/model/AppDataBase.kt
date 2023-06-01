package com.example.lab_03_danp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lab_03_danp.entities.CourseEntity
import com.example.lab_03_danp.entities.StudentEntity
import com.example.lab_03_danp.entities.relations.StudentCourseCrossRef

@Database(
    entities = [
        StudentEntity::class,
        CourseEntity::class,
        StudentCourseCrossRef::class
    ],
    version = 1,
    exportSchema = true
)
abstract class AppDataBase: RoomDatabase() {
    abstract val courseDao: CourseDao
    abstract val studentDao : StudentDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}