package com.example.lab_03_danp.screens.student

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab_03_danp.R
import com.example.lab_03_danp.entities.StudentEntity
import com.example.lab_03_danp.entities.relations.StudentCourseCrossRef
import com.example.lab_03_danp.screens.viewModel.AppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentRegisterScreen(
    viewModel: AppViewModel,
    navHome: () -> Unit
){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        var studentNames by rememberSaveable { mutableStateOf(("")) }
        var studentCod by rememberSaveable { mutableStateOf(("")) }
        var courseId by rememberSaveable { mutableStateOf(("")) }
        var listCourse = viewModel.getAllCourse().observeAsState().value
        Column() {

        }

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center ) {

            item {
                Text(
                    text = "Registrar estudiante",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(150.dp),
                )

                TextField(
                    value = studentNames,
                    onValueChange = {
                        studentNames = it

                    },
                    label = { Text(text = "Nombres y apellidos") }
                )
                TextField(
                    value = studentCod,
                    onValueChange = {
                        studentCod = it

                    },
                    label = { Text(text = "Código estudiante") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

                )
                TextField(
                    value = courseId,
                    onValueChange = {
                        courseId = it
                    },
                    label = { Text(text = "CursoId") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Button(onClick = {
                    viewModel.addStudent(
                        StudentEntity(
                            studentCod.toInt(),
                            studentNames,
                            studentCod
                        )
                    )
                    viewModel.addStudentCourseCrossRef(
                        StudentCourseCrossRef(
                            studentCod.toInt(),
                            courseId.toInt()
                        )
                    )
                }) {
                    Text(text = "Matricular")
                }

                if (listCourse != null) {
                    Column() {
                        listCourse.forEach {
                            Text(
                                text = "Curso Id : " + it.courseId +
                                        ", Asignatura : " + it.courseName

                            )
                        }
                    }
                }

                Button(onClick = {
                    navHome()
                }) {
                    Icon(painter = painterResource(id = R.drawable.baseline_arrow_back_24), contentDescription = null )

                }

            }

        }

    
    }
}