package com.example.lab_03_danp.screens.courseList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab_03_danp.screens.viewModel.AppViewModel

@Composable
fun CourseListScreen(
    viewModel: AppViewModel
){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        var listStudent = viewModel.getAllStudent().observeAsState().value
        var listCourse = viewModel.getAllCourse().observeAsState().value
        var listStudentCourseCrossRef = viewModel.getAllStudentCourseCrossRef().observeAsState().value

        LazyColumn() {
            if (listStudent != null && listCourse != null && listStudentCourseCrossRef != null) {
                listCourse.forEach {
                    var aux = it
                    item {
                        Row() {
                            Text(text = it.courseName + " : ")
                            listStudent.forEach {
                                var aux2 = it
                                listStudentCourseCrossRef.forEach {
                                    if (it.courseId == aux.courseId && it.studentId == aux2.studentId) {
                                        Text(text = " "+aux2.studentName + ",")
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }

    }
}