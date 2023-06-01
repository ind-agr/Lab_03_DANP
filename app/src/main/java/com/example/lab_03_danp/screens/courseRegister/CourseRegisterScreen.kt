package com.example.lab_03_danp.screens.courseRegister

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab_03_danp.R
import com.example.lab_03_danp.entities.CourseEntity
import com.example.lab_03_danp.screens.viewModel.AppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseRegisterScreen(
    viewModel: AppViewModel,
    navHome: () -> Unit
){

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        var courseName by rememberSaveable { mutableStateOf(("")) }

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
            verticalArrangement = Arrangement.Center ) {

            item {
                Text(text = "Registrar Curso ", textAlign = TextAlign.Center,
                    modifier = Modifier.width(150.dp),fontSize = 30.sp,fontWeight = FontWeight.ExtraBold)

                TextField(
                    value = courseName,
                    onValueChange = {
                        courseName = it
                    } ,
                    label = { Text(text = "Nombre del Curso") }
                )
                Button(onClick = {
                    viewModel.addCourse(CourseEntity(0, courseName))
                }) {
                    Text(text = "Registrar")
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