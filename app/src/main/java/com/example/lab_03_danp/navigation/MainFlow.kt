package com.example.lab_03_danp.navigation

import androidx.compose.runtime.Composable
import com.example.lab_03_danp.navigation.Route.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab_03_danp.screens.courseRegister.CourseRegisterScreen
import com.example.lab_03_danp.screens.home.HomeScreen
import com.example.lab_03_danp.screens.student.StudentRegisterScreen
import com.example.lab_03_danp.screens.courseList.CourseListScreen

@Composable
fun MainFlow(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home.route){
        composable(Home.route){
            HomeScreen(
                navStudentRegister = {
                    navController.navigate(StudentRegister.route)
                },
                navCourseRegister = {
                    navController.navigate(CourseRegister.route)
                },
                navCourseList = {
                    navController.navigate(CourseList.route)
                }
            )
        }
        composable(StudentRegister.route){
            StudentRegisterScreen()

        }
        composable(CourseRegister.route){
            CourseRegisterScreen()
        }
        composable(CourseList.route){
            CourseListScreen()
        }
    }
}