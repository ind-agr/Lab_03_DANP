package com.example.lab_03_danp.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    navStudentRegister: () -> Unit,
    navCourseRegister: () -> Unit,
    navCourseList: () -> Unit

){
    Surface(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            Button(onClick = {
                navStudentRegister()
            }) {
                Text(text = "Registrar Estudiante")
            }

            Button(onClick = {
                navCourseRegister()
            }) {
                Text(text = "Registrar Curso")
            }

            Button(onClick = {
                navCourseList()
            }) {
                Text(text = "Mostrar Cursos")
            }
        }
    }

}